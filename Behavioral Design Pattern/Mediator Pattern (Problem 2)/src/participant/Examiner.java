package participant;

import data.BundleCheckRequest;
import data.ExamScript;
import data.SingleScriptRequest;
import data.ScriptBundle;
import mediator.Mediator;

import java.util.List;
import java.util.Random;

public class Examiner extends Participant {
    public Examiner(Mediator mediator, int id) {
        super(mediator, id);
    }

    private int getRandomNumber(int l, int r) {
        Random random = new Random();
        int num = random.nextInt(r - l + 1);
        return num + l;
    }

    public void sendBundleCheckRequest(BundleCheckRequest request) {
        // so this examiner just received a bundle of scripts to check
        ScriptBundle bundle = request.getScriptBundle();
        String str = "";
        for (int i = 0; i < bundle.getScripts().size(); i++) {
            str += bundle.getScripts().get(i).getExamineeID();
            if (i != bundle.getScripts().size() - 1) {
                str += ", ";
            }
        }
        System.out.println("\nExaminer " + id + ": Received scripts of ID- " + str + " to check.");
        List<ExamScript> scripts = bundle.getScripts();
        List<Integer> marks = bundle.getMarks();

        for (int i = 0; i < scripts.size(); i++) {
            // now just evaluating the scripts and placing the mark
            ExamScript currentScript = scripts.get(i);
            currentScript.setMark(getRandomNumber(40, 100)); // mark range from 0 to 100
        }

        int mistakeCount = 0; // need to make sure at least one mistake is done
        for (int i = 0; i < scripts.size(); i++) {
            // now putting the marks in the marksheet
            ExamScript currentScript = scripts.get(i);
            int actualMark = currentScript.getMark();

            double probability = (getRandomNumber(0, 100)) / 100.00; // probability of mistake
            if (probability < 0.5) {
                // the mark will be put correctly
                marks.add(actualMark);
            } else {
                // the mark will be incorrect
                int incorrectMark = getRandomNumber(40, 100);
                if (incorrectMark == actualMark) {
                    incorrectMark = (incorrectMark + 3) % 101;
                }
                marks.add(incorrectMark);
                mistakeCount++;
            }
            currentScript.setScriptStatus(ExamScript.ScriptStatus.CHECKED);
        }
        if (mistakeCount == 0) {
            // if no mistake is done, change the first mark
            marks.set(0, (marks.get(0) + 3) % 101);
        }

        // now send the bundle back to the controller
        System.out.println("Examiner " + id + ": Finished checking script(s) of ID-" + str + " and sent marksheet to controller.");
        mediator.sendMessage(this, request);
    }

    public void sendRecheckRequest(SingleScriptRequest request) {
        assert request.getExamScript() != null && request.getExamScript().getScriptStatus() != ExamScript.ScriptStatus.RECHECKED;
        int num = getRandomNumber(0, 9);
        ExamScript script = request.getExamScript();
        int mark = script.getMark();
        if (num % 3 == 0 && mark <= 98 && mark >= 40) { // giving a 40% chance of result getting changed, 20% increase, 20% decrease
            if (num == 0 || num == 9) {
                // mark will decrease
                script.setMark((script.getMark() - 2 + 101) % 101);
                request.setRecheckStatus(SingleScriptRequest.RecheckStatus.DECREASED);
            } else {
                // mark will increase
                script.setMark((script.getMark() + 2) % 101);
                request.setRecheckStatus(SingleScriptRequest.RecheckStatus.INCREASED);
            }
        } else {
            // mark will remain the same
            request.setRecheckStatus(SingleScriptRequest.RecheckStatus.UNCHANGED);
        }
        script.setScriptStatus(ExamScript.ScriptStatus.RECHECKED);
        // now send the request back to the controller
        System.out.println("Examiner " + id + ": Finished rechecking script of student ID-" + script.getExamineeID()
                + " and sent result to controller.");
        mediator.sendMessage(this, request);
    }
}
