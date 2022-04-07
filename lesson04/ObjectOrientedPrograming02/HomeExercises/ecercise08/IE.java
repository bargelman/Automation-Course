package lesson04.ObjectOrientedPrograming02.HomeExercises.ecercise08;

public class IE extends Web{
    double version = 5.1;
    public void callPrint(){
        System.out.println("The Local Time & Date is: " + timeStamp);
        System.out.println("The Version of IE is: " + version);
        details();
    }
}
