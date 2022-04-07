package lesson04.ObjectOrientedPrograming02.HomeExercises.ecercise06;

public class Square extends Shape {

    @Override
    public double getArea(double sideLength) {

        double area = sideLength * sideLength;
        return area;
    }

    @Override
    public double getPerimeter(double sideLength) {
        double perimeter = sideLength * 4;
        return perimeter;
    }
}
