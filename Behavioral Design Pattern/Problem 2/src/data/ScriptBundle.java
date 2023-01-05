package data;

import java.util.ArrayList;

// this is a bundle of exam scripts

public class ScriptBundle {
    private ArrayList<ExamScript> scripts; // the mark contained in each script is the actual mark
    private int examinerID;
    private ArrayList<Integer> marks; // this is the list of marks sent to controller

    public ArrayList<ExamScript> getScripts() {
        return scripts;
    }

    public void setScripts(ArrayList<ExamScript> scripts) {
        this.scripts = scripts;
    }

    public int getExaminerID() {
        return examinerID;  
    }

    public void setExaminerID(int examinerID) {
        this.examinerID = examinerID;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
    }

    public void addExamScript(ExamScript examScript) {
        // add a new exam script to the bundle
        scripts.add(examScript);
    }
}
