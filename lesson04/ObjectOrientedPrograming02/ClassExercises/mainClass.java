package lesson04.ObjectOrientedPrograming02.ClassExercises;

public class mainClass {

    public static void main(String[] args) {
        TempClass tempClass = new TempClass();
        tempClass.n = 10;
        tempClass.s = "1";
        String st = tempClass.intToString(tempClass.n);
        System.out.println(st + 10);
        int in = tempClass.StringToInt(tempClass.s);
        System.out.println(in + 1);
    }
}
