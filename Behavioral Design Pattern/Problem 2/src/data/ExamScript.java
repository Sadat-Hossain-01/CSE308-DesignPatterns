package data;

public class ExamScript {
    public static final int noOfQuestions = 10;
    private int questionMarks[]; // marks of individual questions
    private int examinerID;
    private int examineeID;
    private int displayedMark;

    public ExamScript(int examinerID, int examineeID) {
        this.examinerID = examinerID;
        this.examineeID = examineeID;
        questionMarks = new int[noOfQuestions];
    }

    private void setMark(int q_idx, int mark) {
        // given q_idx is 1-based, so have to subtract 1
        if (mark > 10) mark = 10; // 10 mark in each question
        questionMarks[q_idx - 1] = mark;
    }

    private int getAddedMarks() {
        int ret = 0;
        for (int i = 0; i < noOfQuestions; i++) {
            ret += questionMarks[i];
        }
        return ret;
    }

    public int getDisplayedMark() {
        return displayedMark;
    }

    public void setDisplayedMark(int displayedMark) {
        this.displayedMark = displayedMark;
    }

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
}
