package lesson04.ObjectOrientedPrograming02.HomeExercises.ecercise03;

public class MainProgramConstructor {
    public static void main(String[] args) {
        MobileDeviceConstructor mobileDevice = new MobileDeviceConstructor();
        mobileDevice.model = "iphone 13";
        mobileDevice.os = 'I';
        mobileDevice.version = 13.2;
        mobileDevice.hasFlash = true;
        mobileDevice.prise = 5000;
        mobileDevice.screenWidth = 5;
        mobileDevice.screenHeight = 4;
        mobileDevice.printParameters();

        int area = mobileDevice.calculateArea();
        System.out.println(area);
        mobileDevice.pictureQuality();
    }
}
