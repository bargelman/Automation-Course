package lesson04.ObjectOrientedPrograming02.HomeExercises.ecercise08;

public class iOS extends Mobile{
    double osVersion = 15.4;
    int price = 5500;
    public void callPrint(){
        System.out.println("The Local Time & Date is: " + timeStamp);
        System.out.println("The Version of iOS is: " + osVersion);
        System.out.println("The price is: " + price);
        details();
    }
}
