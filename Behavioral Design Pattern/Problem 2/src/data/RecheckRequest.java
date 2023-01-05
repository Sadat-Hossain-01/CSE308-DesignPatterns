package data;

public class RecheckRequest extends CheckRequest {
    private ExamScript examScript;
    private int previousMark; // in case of change, for showing the previous mark
    public enum RecheckStatus {
        UNCHANGED,
        CHANGED
    };
    private RecheckStatus recheckStatus;

    public ExamScript getExamScript() {
        return examScript;
    }

    public void setExamScript(ExamScript examScript) {
        this.examScript = examScript;
    }

    public int getPreviousMark() {
        return previousMark;
    }

    public void setPreviousMark(int previousMark) {
        this.previousMark = previousMark;
    }

    public RecheckStatus getRecheckStatus() {
        return recheckStatus;
    }

    public void setRecheckStatus(RecheckStatus recheckStatus) {
        this.recheckStatus = recheckStatus;
    }

    public RecheckRequest(ExamScript examScript) {
        this.examScript = examScript;
        this.previousMark = examScript.getMark();
    }
}
