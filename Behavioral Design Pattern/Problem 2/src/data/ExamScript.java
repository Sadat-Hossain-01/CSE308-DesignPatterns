package data;

public class ExamScript {
    private int examinerID;
    private int examineeID;
    private int mark;
    public enum ScriptStatus {
        UNCHECKED, // sent to examiner for the first time
        CHECKED, // examiner checked, sent to controller
        RECHECK_REQUESTED, // student asked for recheck
        RECHECK_DONE, // recheck done, but not change
    };
    private ScriptStatus scriptStatus;

    public int getExaminerID() {
        return examinerID;
    }

    public void setExaminerID(int examinerID) {
        this.examinerID = examinerID;
    }

    public int getExamineeID() {
        return examineeID;
    }

    public void setExamineeID(int examineeID) {
        this.examineeID = examineeID;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int actualMark) {
        this.mark = actualMark;
    }

    public ScriptStatus getScriptStatus() {
        return scriptStatus;
    }

    public void setScriptStatus(ScriptStatus scriptStatus) {
        this.scriptStatus = scriptStatus;
    }

    public ExamScript(int examineeID) {
        this.examineeID = examineeID;
        this.scriptStatus = ScriptStatus.UNCHECKED;
    }
}
