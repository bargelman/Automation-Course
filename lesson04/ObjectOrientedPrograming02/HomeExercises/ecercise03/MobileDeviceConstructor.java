package lesson04.ObjectOrientedPrograming02.HomeExercises.ecercise03;

public class MobileDeviceConstructor {
    String model;
    char os;
    double version;
    boolean hasFlash;
    int prise;
    int screenWidth;
    int screenHeight;

    void printParameters()
    {
        System.out.println("The Mobile Model is: " + model);
        System.out.println("The Operator System is: " + os);
        System.out.println("The Version is: " + version);
        System.out.println("If Camera has a flash? " + hasFlash);
        System.out.println("The price is: " + prise);
    }
    int calculateArea() {
        return screenHeight * screenWidth;
    }
    void pictureQuality()
    {
        if(hasFlash){
            System.out.println("Good Quality");
        } else {
            System.out.println("Bad Quality");
        }
    }

}
