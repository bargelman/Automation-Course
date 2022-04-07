package lesson04.ObjectOrientedPrograming02.HomeExercises.ecercise05;

public class MainProgram {
    public static void main(String[] args) {
        Israel il = new Israel();
        System.out.println(il.myTraditionalFood());
        System.out.println(il.myTraditionalVacation());
        System.out.println(il.myTraditionalLanguage());

        USA usa = new USA();
        System.out.println(usa.myTraditionalFood());
        System.out.println(usa.myTraditionalVacation());
        System.out.println(usa.myTraditionalLanguage());

        China china = new China();
        System.out.println(china.myTraditionalFood());
        System.out.println(china.myTraditionalVacation());
        System.out.println(china.myTraditionalLanguage());
    }
}
