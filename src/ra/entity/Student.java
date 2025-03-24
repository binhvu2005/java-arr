package ra.entity;

import ra.validate.Validate;

import java.util.Date;
import java.util.Scanner;

public class Student implements IApp{
    private String studentId;
    private String studentName;
    private Date birthDay;
    private String phoneNumber;
    private boolean sex;
    private String email;
    private String major;
    private String className;
    private float gpa;
    private byte status;

    public Student() {
        this.status = 1;
    }

    public Student(String studentName, Date birthDay, String phoneNumber, boolean sex, String email, String major, String className, float gpa, byte status) {
        this.studentName = studentName;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.email = email;
        this.major = major;
        this.className = className;
        this.gpa = gpa;
        this.status = status;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSex() {
        return sex;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner sc) {
        do {
            System.out.println("Enter Student ID (SVxxxxx):");
            String id = Validate.validateStudentId(sc.nextLine());
            if (id != null) {
                this.studentId = id;
                break;
            } else {
                System.err.println("Invalid Student ID format.");
            }
        } while (true);

        do {
            System.out.println("Enter Student Name:");
            String name = Validate.validateStudentName(sc.nextLine());
            if (name != null) {
                this.studentName = name;
                break;
            } else {
                System.err.println("Student Name cannot be empty.");
            }
        } while (true);

        do {
            System.out.println("Enter Birth Day (dd/MM/yyyy):");
            Date birthDay = Validate.validateBirthDay(sc.nextLine());
            if (birthDay != null) {
                this.birthDay = birthDay;
                break;
            } else {
                System.err.println("Invalid Birth Day format.");
            }
        } while (true);

        do {
            System.out.println("Enter Phone Number (0xxxxxxxxx):");
            String phoneNumber = Validate.validatePhoneNumber(sc.nextLine());
            if (phoneNumber != null) {
                this.phoneNumber = phoneNumber;
                break;
            } else {
                System.err.println("Invalid Phone Number format.");
            }
        } while (true);

        System.out.println("Enter Gender (true/false):");
        this.sex = sc.nextBoolean();
        sc.nextLine();

        do {
            System.out.println("Enter Email (xxx@gmail.com):");
            String email = Validate.validateEmail(sc.nextLine());
            if (email != null) {
                this.email = email;
                break;
            } else {
                System.err.println("Invalid Email format.");
            }
        } while (true);

        do {
            System.out.println("Enter Major:");
            String major = Validate.validateMajor(sc.nextLine());
            if (major != null) {
                this.major = major;
                break;
            } else {
                System.err.println("Major cannot be empty.");
            }
        } while (true);

        do {
            System.out.println("Enter Class:");
            String className = Validate.validateClassName(sc.nextLine());
            if (className != null) {
                this.className = className;
                break;
            } else {
                System.err.println("Class cannot be empty.");
            }
        } while (true);

        do {
            System.out.println("Enter GPA:");
            Float gpa = Validate.validateGPA(sc.nextLine());
            if (gpa != null) {
                this.gpa = gpa;
                break;
            } else {
                System.err.println("Invalid GPA format or value.");
            }
        } while (true);

        do {
            System.out.println("Enter Status (1-3):");
            Byte status = Validate.validateStatus(sc.nextLine());
            if (status != null) {
                this.status = status;
                break;
            } else {
                System.err.println("Invalid Status format or value.");
            }
        } while (true);
    }

    @Override
    public void displayData() {
        System.out.println("student ID :" + studentId);
        System.out.println("student name :" + studentName);
        System.out.println("birth day :" + birthDay);
        System.out.println("phone number :" + phoneNumber);
        System.out.println("sex :" + sex);
        System.out.println("email :" + email);
        System.out.println("major :" + major);
        System.out.println("class :" + className);
        System.out.println("gpa :" + gpa);
        System.out.println("status :" + status);
    }
}
