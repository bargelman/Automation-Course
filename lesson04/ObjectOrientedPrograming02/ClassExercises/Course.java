package lesson04.ObjectOrientedPrograming02.ClassExercises;

public class Course {
    static String courseName;
    String studentFullName;
    static int price;
    int studentId;
    long phoneNumber;
    long password;

    Course(String studentFullName, int studentId, int phoneNumber){
        this.studentFullName = studentFullName;
        this.studentId = studentId;
        this.phoneNumber = phoneNumber;
    }
    public void printDetails(){
        System.out.println("=====Details=====");
        System.out.println("Course Name: " + courseName);
        System.out.println("Full Name: " + studentFullName);
        System.out.println("Prise: " + price);
        System.out.println("Student ID: " + studentId);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Password: " + getPassword());
    }
    public long getPassword(){
        password = phoneNumber / 3;
        return password;
    }
}
