package data;

public class ExamScript {
    private int examinerID;
    private int examineeID;
    private int mark;

    public enum ScriptStatus {NOT_CHECKED, CHECKED, RECHECKED};
    private ScriptStatus status;

    public void setScriptStatus(ScriptStatus status) {
        this.status = status;
    }

    public void setExaminerID(int teacherID) {
        this.examinerID = teacherID;
    }

    public ScriptStatus getScriptStatus() {
        return status;
    }

    public int getExaminerID() {
        return examinerID;
    }

    public int getExamineeID() {
        return examineeID;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int actualMark) {
        this.mark = actualMark;
    }

    public ExamScript(int examineeID) {
        this.examineeID = examineeID;
        this.status = ScriptStatus.NOT_CHECKED;
    }
}
