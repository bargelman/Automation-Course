package lesson04.ObjectOrientedPrograming02.HomeExercises.ecercise08;

public class Main {
    public static void main(String[] args) {
        Chrome chrome = new Chrome();
        chrome.callPrint();
        System.out.println();
        IE ie = new IE();
        ie.callPrint();
        System.out.println();
        Desktop desktop = new Desktop();
        desktop.details();
        System.out.println();
        Android android = new Android();
        android.cllPrint();
        System.out.println();
        iOS ios = new iOS();
        ios.callPrint();

    }
}
