package mediator;

import data.*;
import participant.Examinee;
import participant.Examiner;
import participant.Participant;

import java.util.ArrayList;
import java.util.List;

public class ExamController implements Mediator {
    private List<Examiner> examinerList;
    private List<Examinee> examineeList;
    private List<Integer> centralMarksheet; // local record of marksheet in controller
    private List<ExamScript> examScripts;
    private int evalDone = 0; // number of evaluated exam scripts received

    public void setExaminerList(List<Examiner> examinerList) {
        this.examinerList = examinerList;
    }

    public void setExamineeList(List<Examinee> examineeList) {
        this.examineeList = examineeList;
    }

    public void setExamScriptList(List<ExamScript> scripts) {
        this.examScripts = scripts;
        centralMarksheet = new ArrayList<>();
        for (int i = 0; i < scripts.size(); i++) {
            centralMarksheet.add(0);
        }
    }

    private void checkForErrors(ScriptBundle bundle) {
        List<Integer> marksheet = bundle.getMarks();
        List<ExamScript> scripts = bundle.getScripts();

        for (int i = 0; i < scripts.size(); i++) {
            int studentID = scripts.get(i).getExamineeID();
            if (scripts.get(i).getMark() != marksheet.get(i)) {
                // mistook in mark sheet
                int wrongMark = marksheet.get(i);
                int rightMark = scripts.get(i).getMark();
                marksheet.set(i, scripts.get(i).getMark());
                System.out.println("Exam Controller: Mistake found, corrected mark of student ID-" + studentID +
                        " from " + wrongMark + " to " + rightMark + ".");
            }
        }

        for (int i = 0; i < marksheet.size(); i++) {
            centralMarksheet.set(scripts.get(i).getExamineeID() - 1, marksheet.get(i)); // saving the marks in the central marksheet
        }
    }

    private void publishResult() {
        System.out.println("\nExam Controller: Publishing results to students...");
        for (int i = 0; i < examineeList.size(); i++) {
            int mark = centralMarksheet.get(i);
            assert mark == examScripts.get(i).getMark();
            System.out.println("Exam Controller: Result forwarded to student ID-" + (i + 1) + ".");
            Examinee examinee = examineeList.get(i);
            examinee.sendResult(mark);
        }
    }

    @Override
    public void sendMessage(Participant from, CheckRequest checkRequest) {
        if (from instanceof Examiner && checkRequest instanceof BundleCheckRequest) {
            // receiving response of script bundle check
            String str = "";
            ScriptBundle bundle = ((BundleCheckRequest) checkRequest).getScriptBundle();
            for (int i = 0; i < bundle.getScripts().size(); i++) {
                str += bundle.getScripts().get(i).getExamineeID();
                if (i != bundle.getScripts().size() - 1) {
                    str += ", ";
                }
            }
            System.out.println("Exam Controller: Received scripts and marksheet of ID-" + str + " from examiner " + from.getID() + ".");
            for (int i = 0; i < bundle.getScripts().size(); i++) {
                int studentID = bundle.getScripts().get(i).getExamineeID();
                System.out.println("Exam Controller: Student ID- " + studentID + ", mark- " + bundle.getMarks().get(i) + ".");
            }
            // check for errors in this bundle
            checkForErrors(((BundleCheckRequest) checkRequest).getScriptBundle());

            evalDone += ((BundleCheckRequest) checkRequest).getScriptBundle().getScripts().size();
            if (evalDone == examineeList.size()) {
                // all scripts have been evaluated
                publishResult();
            }
        } else if (from instanceof Examinee && checkRequest instanceof SingleScriptRequest) {
            // received recheck request, now need to forward it to examiner
            // first find the exam script of the student, and assign it to the request
            System.out.println("Exam Controller: Received recheck request from student ID-" + from.getID() + ".");
            SingleScriptRequest request = (SingleScriptRequest) checkRequest;
            int studentID = request.getExamineeID();
            ExamScript desiredScript = examScripts.get(studentID - 1);

            // first check if this student has already rechecked once
            if (desiredScript.getScriptStatus() == ExamScript.ScriptStatus.RECHECKED) {
                System.out.println("Exam Controller: Sorry, student ID-" + studentID + " has already rechecked once.");
                return;
            }
            request.setExamScript(desiredScript);
            // forward the request to the examiner
            int examinerID = desiredScript.getExaminerID();
            Examiner examiner = examinerList.get(examinerID - 1);
            System.out.println("Exam Controller: Forwarded recheck request to examiner " + examinerID + ".");
            examiner.sendRecheckRequest(request);
        } else if (from instanceof Examiner && checkRequest instanceof SingleScriptRequest) {
            // received response of recheck request from examiner
            SingleScriptRequest request = (SingleScriptRequest) checkRequest;
            int examineeID = request.getExamineeID();
            System.out.println("Exam Controller: Received recheck response from examiner " + from.getID()
                    + " for student ID-" + examineeID + ".");

            assert request.getRecheckStatus() != SingleScriptRequest.RecheckStatus.PENDING;

            if (request.getRecheckStatus() == SingleScriptRequest.RecheckStatus.UNCHANGED) {
                System.out.println("Exam Controller: No change of mark for student ID-" + examineeID + ".");
            } else {
                int prevMark = centralMarksheet.get(examineeID - 1);
                int updatedMark = request.getExamScript().getMark();
                assert prevMark != updatedMark; // marks must change
                if (prevMark < updatedMark) {
                    assert request.getRecheckStatus() == SingleScriptRequest.RecheckStatus.INCREASED;
                    // update the mark in central marksheet
                    centralMarksheet.set(examineeID - 1, updatedMark);
                    System.out.println("Exam Controller: Marks increased for student ID-" + examineeID + "."
                            + " Previous mark: " + prevMark + ", Updated mark: " + updatedMark + ".");
                } else {
                    assert request.getRecheckStatus() == SingleScriptRequest.RecheckStatus.DECREASED;
                    // update the mark in central marksheet
                    centralMarksheet.set(examineeID - 1, updatedMark);
                    System.out.println("Exam Controller: Marks decreased for student ID-" + examineeID + "."
                            + " Previous mark: " + prevMark + ", Updated mark: " + updatedMark + ".");
                }
            }
        }
    }
}