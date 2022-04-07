package lesson04.ObjectOrientedPrograming02.ClassExercises;

public class TempClass {
    int n;
    String s;
    public String intToString(int tempVal){
        String convertInt = Integer.toString(tempVal);
        return convertInt;
    }

    public int StringToInt(String tempVal){
        int convertString = Integer.parseInt(tempVal);
        return convertString;

    }
}
