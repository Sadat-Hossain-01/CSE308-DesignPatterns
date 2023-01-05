package mediator;

import data.*;
import participant.Examinee;
import participant.Examiner;
import participant.Participant;

import java.util.List;

public class ExamController implements Mediator {
    private List<Examiner> examinerList;
    private List<Examinee> examineeList;
    private List<Integer> marks; // local record of marksheet in controller
    private List<ExamScript> examScripts;
    private int evalDone = 0; // number of evaluated exam scripts received

    public List<Examiner> getExaminerList() {
        return examinerList;
    }

    public void setExaminerList(List<Examiner> examinerList) {
        this.examinerList = examinerList;
    }

    public List<Examinee> getExamineeList() {
        return examineeList;
    }

    public void setExamineeList(List<Examinee> examineeList) {
        this.examineeList = examineeList;
    }

    public void setExamScriptList(List<ExamScript> scripts) {
        this.examScripts = scripts;
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
                System.out.println("\nExam Controller: corrected mark of student id-" + studentID +
                        " from " + wrongMark + " to " + rightMark + ".");
            }
        }

        marks = marksheet; // saving the latest marksheet
    }

    private void publishResult() {
        for (int i = 0; i < examineeList.size(); i++) {
            int mark = marks.get(i);
            assert mark == examScripts.get(i).getMark();
            System.out.println("\nExam Controller: result sent to student id-" + (i + 1));
            Examinee examinee = examineeList.get(i);
            examinee.sendResult(mark);
        }
    }

    @Override
    public void sendMessage(Participant from, CheckRequest checkRequest) {
        if (from instanceof Examiner && checkRequest instanceof BundleCheckRequest) {
            // receiving response of script bundle check
            System.out.println("\nExam Controller: received scripts and marksheet from examiner " + from.getID() + " after checking.");
            // check for errors in this bundle
            checkForErrors(((BundleCheckRequest) checkRequest).getScriptBundle());

            evalDone += ((BundleCheckRequest)checkRequest).getScriptBundle().getScripts().size();
            if (evalDone == examineeList.size()) {
                // all scripts have been evaluated
                publishResult();
            }
        }
        else if (from instanceof Examinee && checkRequest instanceof SingleScriptRequest) {
            // received recheck request, now need to forward it to examiner
            // first find the exam script of the student, and assign it to the request
            System.out.println("\nExam Controller: received recheck request from student id-" + from.getID());
            SingleScriptRequest request = (SingleScriptRequest) checkRequest;
            int studentID = request.getExamineeID();
            ExamScript desiredScript = examScripts.get(studentID - 1);
            request.setExamScript(desiredScript);
            // forward the request to the examiner
            int examinerID = desiredScript.getExaminerID();
            Examiner examiner = examinerList.get(examinerID - 1);
            System.out.println("\nExam Controller: forwarded recheck request to examiner " + examinerID);
            examiner.sendRecheckRequest(request);
        }
        else if (from instanceof Examiner && checkRequest instanceof SingleScriptRequest) {
            // received response of recheck request from examiner
            SingleScriptRequest request = (SingleScriptRequest) checkRequest;
            int examineeID = request.getExamineeID();
            System.out.println("\nExam Controller: received recheck response from examiner " + from.getID()
                    + " for student id-" + examineeID);

            assert request.getRecheckStatus() != SingleScriptRequest.RecheckStatus.PENDING;

            if (request.getRecheckStatus() == SingleScriptRequest.RecheckStatus.UNCHANGED) {
                System.out.println("\nExam Controller: marks remain same for student-" + examineeID);
            }
            else {
                int prevMark = marks.get(examineeID - 1);
                int updatedMark = request.getExamScript().getMark();
                assert prevMark != updatedMark; // marks must change
                if (prevMark < updatedMark) {
                    assert request.getRecheckStatus() == SingleScriptRequest.RecheckStatus.DECREASED;
                    // update the mark in central marksheet
                    marks.set(examineeID - 1, updatedMark);
                    System.out.println("\nExam Controller: marks decreased for student-" + examineeID);
                }
                else {
                    assert request.getRecheckStatus() == SingleScriptRequest.RecheckStatus.INCREASED;
                    // update the mark in central marksheet
                    marks.set(examineeID - 1, updatedMark);
                    System.out.println("\nExam Controller: marks increased for student-" + examineeID);
                }
            }
        }
    }
}