package data;

public class SingleScriptRequest extends CheckRequest {
    // basically used for rechecking
    private ExamScript examScript;
    private int examineeID;
    public enum RecheckStatus {
        PENDING, // recheck is yet to be done
        UNCHANGED,
        INCREASED,
        DECREASED
    };
    private RecheckStatus recheckStatus;

    public ExamScript getExamScript() {
        return examScript;
    }

    public void setExamScript(ExamScript examScript) {
        this.examScript = examScript;
    }

    public RecheckStatus getRecheckStatus() {
        return recheckStatus;
    }

    public void setRecheckStatus(RecheckStatus recheckStatus) {
        this.recheckStatus = recheckStatus;
    }

    public int getExamineeID() {
        return examineeID;
    }

    public SingleScriptRequest(int examineeID) {
        this.examineeID = examineeID;
        this.recheckStatus = RecheckStatus.PENDING;
    }
}
