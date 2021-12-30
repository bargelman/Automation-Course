package com.lesson01;

public class DataTypesNonPrimitives06 {
    public static void main(String[] args) {
        String bonJovi = "Shot through the heart and you`re to blame darling you give love a bad name";
        String[] bonJoviArray = bonJovi.split(" ");
//        A)
        String noSpace = bonJovi.replaceAll(" ", "");
        System.out.println(noSpace);

//        B)
        System.out.println(bonJoviArray.length);

//        C)
        String first = bonJoviArray[0];
        String upperFirst = first.toUpperCase();
        String last = bonJoviArray[bonJoviArray.length-1];
        String upperLast = last.toUpperCase();
        System.out.println(upperFirst + " " + upperLast);
    }
}
