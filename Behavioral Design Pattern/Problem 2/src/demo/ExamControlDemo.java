package demo;

import data.BundleCheckRequest;
import data.ExamScript;
import data.ScriptBundle;
import mediator.ExamController;
import participant.Examinee;
import participant.Examiner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamControlDemo {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ExamController controller = new ExamController();
        List<Examiner> examiners = new ArrayList<>();
        List<Examinee> examinees = new ArrayList<>();

        int noOfExaminer = 0, noOfExaminee = 0;
        boolean inpon = true;

        System.out.print("Enter number of examinees: ");
        while (inpon) {
            try {
                noOfExaminee = scanner.nextInt();
                if (noOfExaminee <= 0) throw new Exception();
                else inpon = false;
            } catch (Exception e) {
                System.out.println("Please input a valid number.");
            }
        }

        inpon = true;
        System.out.print("Enter number of examiners: ");
        while (inpon) {
            try {
                noOfExaminer = scanner.nextInt();
                if (noOfExaminer <= 0 || noOfExaminer > noOfExaminee) throw new Exception();
                else inpon = false;
            } catch (Exception e) {
                if (noOfExaminer > noOfExaminee) System.out.println("Number of examiners should not be more than that of examinees.");
                else System.out.println("Please input a valid number.");
            }
        }

        List<ScriptBundle> bundles = new ArrayList<>(); // bundle for each examiner

        // initializing examiners and examinees
        for (int i = 0; i < noOfExaminee; i++) {
            examinees.add(new Examinee(controller, i + 1));
        }
        for (int i = 0; i < noOfExaminee; i++) {
            examiners.add(new Examiner(controller, i + 1));
            bundles.add(new ScriptBundle());
        }

        controller.setExamineeList(examinees);
        controller.setExaminerList(examiners);

        // first create the exam scripts
        List<ExamScript> scripts = new ArrayList<>();
        for (int i = 0; i < noOfExaminee; i++) {
            ExamScript script = new ExamScript(i + 1);
            scripts.add(script);
        }

        controller.setExamScriptList(scripts);

        // script of student with id (i + 1) will go to examiner with id (i MOD noOfExaminers) + 1
        for (int i = 0; i < noOfExaminee; i++) {
            ExamScript currentScript = scripts.get(i); // student id is i + 1
            int teacherID = (i % noOfExaminer) + 1;
            // bundle for teacher with id j is in index j - 1
            currentScript.setExaminerID(teacherID);
            ScriptBundle desiredBundle = bundles.get(teacherID - 1);
            desiredBundle.addExamScript(currentScript);
        }

        // now send the bundles to respective examiners
        // but will encapsulate the bundle in a BundleCheckRequest class
        for (int i = 0; i < noOfExaminer; i++) {
            Examiner examiner = examiners.get(i);
            ScriptBundle bundleToBeSent = bundles.get(i);
            BundleCheckRequest request = new BundleCheckRequest(bundleToBeSent, i + 1);
            examiner.sendBundleCheckRequest(request);
        }

        while (true) {
            // recheck phase
            System.out.print("\nEnter student ID to recheck: (0 to quit) ");
            int studentID = 0;
            inpon = true;
            while (inpon) {
                try {
                    studentID = scanner.nextInt();
                    if (studentID == 0) {
                        System.out.println("Exiting...");
                        inpon = false;
                        break;
                    }
                    else if (studentID < 0 || studentID > noOfExaminee) throw new Exception();
                    else inpon = false;
                } catch (Exception e) {
                    if (studentID > noOfExaminee) System.out.println("Number of total students is " + noOfExaminee + ".");
                    System.out.println("Please input a valid number.");
                }
            }
            if (studentID == 0) break;
            // request the controller to recheck
            examinees.get(studentID - 1).requestRecheck();
        }

        scanner.close();
    }
}
