package ra.business;

import ra.entity.Student;
import ra.presentation.StudentApplication;
import ra.validate.Validate;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentBusiness {
    public static void displayListStudent(){
        if(StudentApplication.cntStudent == 0){
            System.out.println("List of students is empty");
            return;
        }
        for (int i = 0; i < StudentApplication.cntStudent; i++) {
            if(StudentApplication.arrStudent[i] != null){
                StudentApplication.arrStudent[i].displayData();
            }
        }
    }
    public  static void addStudent(Scanner sc){
        System.out.println("Enter number of student");
        try {
            int num = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < num; i++) {
                Student student = new Student();
                student.inputData(sc);
                if (StudentApplication.cntStudent < StudentApplication.arrStudent.length) {
                    StudentApplication.arrStudent[StudentApplication.cntStudent] = student;
                    StudentApplication.cntStudent++;
                } else {
                    System.out.println("Student list is full! Cannot add more students.");
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter a number.");
            sc.nextLine(); // Clear the invalid input
        }
    }
    public static void updateStudent(Scanner sc) {
        if (StudentApplication.cntStudent > 0){
            System.out.println("Enter student ID to update:");
            String studentId = Validate.validateStudentId(sc.nextLine());

            boolean found = false;
            for (int i = 0; i < StudentApplication.cntStudent; i++) {
                if (StudentApplication.arrStudent[i].getStudentId().equals(studentId)) {
                    System.out.println("Current student information:");
                    StudentApplication.arrStudent[i].displayData();
                    System.out.println("Enter new student information:");
                    StudentApplication.arrStudent[i].inputData(sc);
                    System.out.println("Student information updated.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Student with ID " + studentId + " not found.");
            }
        }else {
            System.out.println("Student ID not found.");
        }
    }
    public static void deleteStudent(Scanner sc) {
        if (StudentApplication.cntStudent > 0) {
            System.out.println("Enter student ID to delete:");
            String studentId = sc.nextLine();

            int indexToDelete = -1;
            for (int i = 0; i < StudentApplication.cntStudent; i++) {
                if (StudentApplication.arrStudent[i].getStudentId().equals(studentId)) {
                    indexToDelete = i;
                    break;
                }
            }

            if (indexToDelete != -1) {
                for (int i = indexToDelete; i < StudentApplication.cntStudent - 1; i++) {
                    StudentApplication.arrStudent[i] = StudentApplication.arrStudent[i + 1];
                }
                StudentApplication.arrStudent[StudentApplication.cntStudent - 1] = null;
                StudentApplication.cntStudent--;
                System.out.println("Student with ID " + studentId + " deleted.");
            } else {
                System.err.println("Student with ID " + studentId + " not found.");
            }
        } else {
            System.err.println("Student list is empty.");
        }
    }
    public static void searchStudent(Scanner sc) {
        System.out.println("Search Student Menu:");
        System.out.println("1. Search by Student Name");
        System.out.println("2. Search by Class Name");
        System.out.println("3. Search by GPA Range");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter your choice: ");

        try {
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    searchByName(sc);
                    break;
                case 2:
                    searchByClass(sc);
                    break;
                case 3:
                    searchByGpaRange(sc);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter a number.");
            sc.nextLine();
        }
    }

    private static void searchByName(Scanner sc) {
        System.out.print("Enter student name to search: ");
        String name = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < StudentApplication.cntStudent; i++) {
            if (StudentApplication.arrStudent[i].getStudentName().toLowerCase().contains(name.toLowerCase())) {
                StudentApplication.arrStudent[i].displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching students found.");
        }
    }

    private static void searchByClass(Scanner sc) {
        System.out.print("Enter class name to search: ");
        String className = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < StudentApplication.cntStudent; i++) {
            if (StudentApplication.arrStudent[i].getClassName().toLowerCase().equals(className.toLowerCase())) {
                StudentApplication.arrStudent[i].displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching students found.");
        }
    }

    private static void searchByGpaRange(Scanner sc) {
        try {
            System.out.print("Enter minimum GPA: ");
            float minGpa = sc.nextFloat();
            System.out.print("Enter maximum GPA: ");
            float maxGpa = sc.nextFloat();
            sc.nextLine();
            boolean found = false;

            for (int i = 0; i < StudentApplication.cntStudent; i++) {
                float gpa = StudentApplication.arrStudent[i].getGpa();
                if (gpa >= minGpa && gpa <= maxGpa) {
                    StudentApplication.arrStudent[i].displayData();
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No matching students found.");
            }
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter a number.");
            sc.nextLine();
        }
    }

    public static void sortStudent(Scanner sc) {
        System.out.println("1.Sort by name ascending");
        System.out.println("2.Sort by name descending");
        System.out.println("3.Sort by GPA ascending");
        System.out.println("4.Sort by GPA descending");
        System.out.print("Enter your choice: ");
        try{
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    sortByNameAscending();
                    break;
                case 2:
                    sortByNameDescending();
                    break;
                case 3:
                    sortByGpaAscending();
                    break;
                case 4:
                    sortByGpaDescending();
                    break;
                default:
                    System.err.println("Invalid choice.");
            }
        }catch (InputMismatchException e){
            System.err.println("Invalid input. Please enter a number.");
            sc.nextLine();
        }
    }
    private static void sortByNameAscending() {
        for (int i = 0; i < StudentApplication.cntStudent-1; i++) {
            for (int j = 1; j < StudentApplication.cntStudent-1-i; j++) {
                if (StudentApplication.arrStudent[j].getStudentName().compareTo(StudentApplication.arrStudent[j + 1].getStudentName()) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }
    private static void sortByNameDescending() {
        for (int i = 0; i < StudentApplication.cntStudent - 1; i++) {
            for (int j = 0; j < StudentApplication.cntStudent - i - 1; j++) {
                if (StudentApplication.arrStudent[j].getStudentName().compareTo(StudentApplication.arrStudent[j + 1].getStudentName()) < 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private static void sortByGpaAscending() {
        for (int i = 0; i < StudentApplication.cntStudent - 1; i++) {
            for (int j = 0; j < StudentApplication.cntStudent - i - 1; j++) {
                if (StudentApplication.arrStudent[j].getGpa() > StudentApplication.arrStudent[j + 1].getGpa()) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private static void sortByGpaDescending() {
        for (int i = 0; i < StudentApplication.cntStudent - 1; i++) {
            for (int j = 0; j < StudentApplication.cntStudent - i - 1; j++) {
                if (StudentApplication.arrStudent[j].getGpa() < StudentApplication.arrStudent[j + 1].getGpa()) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private static void swap(int i, int j) {
        Student temp = StudentApplication.arrStudent[i];
        StudentApplication.arrStudent[i] = StudentApplication.arrStudent[j];
        StudentApplication.arrStudent[j] = temp;
    }
}
