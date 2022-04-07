package lesson04.ObjectOrientedPrograming02.ClassExercises;

public class CarListMainConstructor {
    public static void main(String[] args) {
        carConstructor c1 = new carConstructor("Toyota", "Corolla", 2000, 85000, true);
        c1.print();
        carConstructor c2 = new carConstructor("Tesla", "Model 3",2022, 150000, false);
        c2.print();
    }
}
