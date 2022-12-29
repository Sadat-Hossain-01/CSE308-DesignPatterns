package data;

import java.util.ArrayList;

// this is a bundle of exam scripts sent to a teacher

public class ExamBundle {
    private ArrayList<ExamScript> scripts; // the mark contained in each script is the actual mark
    private int examinerID;
    private ArrayList<Integer> marks; // this is the list of marks sent to controller
}
