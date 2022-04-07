package lesson04.ObjectOrientedPrograming02.HomeExercises.ecercise06;

public class MainShape {
    public static double sideLength = 5;
    public static double radius = 3;

    public static void main(String[] args) {
        System.out.println();
        Shape.definition();
        System.out.println();
        Square square = new Square();
        System.out.println("The Area of Square with length side of: " + sideLength + " is: " + square.getArea(sideLength));
        System.out.println("The Perimeter of Square with length side of: " + sideLength + " is: " +square.getPerimeter(sideLength));

        Circle circle = new Circle();
        System.out.println("The Area of Circle with Radius side of: " + radius + " is: " + circle.getArea(radius));
        System.out.println("The Perimeter of Circle with Radius side of: " + radius + " is: " + circle.getPerimeter(radius));

    }
}
