package lesson04.ObjectOrientedPrograming02.ClassExercises;

public class CourseMain {
    public static void main(String[] args) {
        Course.courseName = "Automation";
        Course.price = 8000;
        Course student1 = new Course("Bar Gelman", 304309388, 524399880);
        student1.printDetails();
        Course student2 = new Course("Michael Ruin", 305475741, 528450285);
        student2.printDetails();
    }
}
