package lesson04.ObjectOrientedPrograming02.HomeExercises.ecercise08;

public class Android extends Mobile{
    double osVersion = 12.3;
    int price = 3500;
    public void cllPrint(){
        System.out.println("The Local Time & Date is: " + timeStamp);
        System.out.println("The Version of Android is: " + osVersion);
        System.out.println("The price is: " + price);
        details();
    }
}
