package lesson04.ObjectOrientedPrograming02.ClassExercises;

public class carConstructor {
    String manufacturer, model;
    int price ,year;
    boolean hasABS;

    carConstructor(String screenHeight, String model, int year, int price, boolean hasABS)
    {
        this.manufacturer = screenHeight;
        this.model = model;
        this.year = year;
        this.price = price;
        this.hasABS = hasABS;
    }
    void print()
    {
        System.out.println("----- Car Details -----");
        System.out.println("Car's manufacturer: " + manufacturer);
        System.out.println("Car's model: " + model);
        System.out.println("Car's price: " + price);
        System.out.println("YEAR: " + year);
        String abs = printABS();
        System.out.println(abs);
    }
    String printABS()
    {
        if(hasABS)
            return "ABS? YES";
        else
            return "ABS? NO";
    }
}

