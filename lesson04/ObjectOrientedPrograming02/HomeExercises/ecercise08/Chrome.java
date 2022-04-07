package lesson04.ObjectOrientedPrograming02.HomeExercises.ecercise08;

public class Chrome extends Web {
    double version = 14.1;
    public void callPrint(){
        System.out.println("The Local Time & Date is: " + timeStamp);
        System.out.println("The Version of Chrome is: " + version);
        details();
    }
}
