package lesson04.ObjectOrientedPrograming02.HomeExercises.ecercise06;

public class Circle extends Shape{
    final double  PI = 3.14;
    @Override
    public double getArea(double radius) {
        double area = radius * radius * PI ;
        return area;
    }

    @Override
    public double getPerimeter(double radius) {
        double perimeter = 2 * PI *radius;
        return perimeter;
    }
}
