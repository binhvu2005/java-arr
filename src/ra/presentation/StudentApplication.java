package ra.presentation;

import ra.business.StudentBusiness;
import ra.entity.Student;
import java.util.Scanner;

public class StudentApplication {
    public static final Student[] arrStudent = new Student[100];
    public static int cntStudent = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        displayMenu(sc);
    }

    public static void displayMenu(Scanner sc) {
        while (true) {
            System.out.println("**************Student Menu******************");
            System.out.println("1.Display List Student");
            System.out.println("2.Add Student");
            System.out.println("3.Update Student");
            System.out.println("4.Delete Student");
            System.out.println("5.Search Student");
            System.out.println("6.Arrange Student");
            System.out.println("0.Exit");
            System.out.println("Choose an option");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    StudentBusiness.displayListStudent();
                    break;
                case 2:
                    StudentBusiness.addStudent(sc);
                    break;
                case 3:
                    StudentBusiness.updateStudent(sc);
                    break;
                case 4:
                    StudentBusiness.deleteStudent(sc);
                    break;
                case 5:
                    StudentBusiness.searchStudent(sc);
                    break;
                case 6:
                    StudentBusiness.sortStudent(sc);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Choice is valid, please try again");
            }
        }
    }
}
