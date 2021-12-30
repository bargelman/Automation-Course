package com.lesson01;

public class DataTypesNonPrimitives04 {
    public static void main(String[] args) {
        String[][] dimensionalArray = new String[2][3];
        dimensionalArray [0][0] = "Moshe";
        dimensionalArray [0][1] = "22";
        dimensionalArray [0][2] = "Jerusalem";
        dimensionalArray [1][0] = "Josef";
        dimensionalArray [1][1] = "45";
        dimensionalArray [1][2] = "London";

        System.out.println(dimensionalArray[0][2]);
    }
}
