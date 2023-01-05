package mediator;

import data.BundleCheckRequest;
import data.CheckRequest;
import data.RecheckRequest;
import participant.Examinee;
import participant.Examiner;
import participant.Participant;

import java.util.List;

public class ExamController implements Mediator {
    private List<Examiner> examinerList;
    private List<Examinee> examineeList;

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

    @Override
    public void sendMessage(Participant from, CheckRequest checkRequest) {
        if (from instanceof Examiner && checkRequest instanceof BundleCheckRequest) {
            // receiving response of script bundle check
        }
        else if (from instanceof Examinee && checkRequest instanceof RecheckRequest) {

        }
        else if (from instanceof Examiner && checkRequest instanceof RecheckRequest) {

        }
    }
}