package com.lesson01;

public class DataTypesNonPrimitives01 {

    public static void main(String[] args) {
//        A)
        String firstName = "Bar";
        String lastName = "Gelman";
        int age = 34;
//        B)
        String strAge = Integer.toString((age));
        System.out.println(strAge);
//        C)
        String fullName = firstName.concat(" "+lastName);
        System.out.println(fullName);
//        D)
        String upperFullName = fullName.toUpperCase();
        System.out.println(upperFullName);
//        E)
        System.out.println(fullName.length());
//        F)
        boolean compare = strAge.equals(fullName);
        System.out.println(compare);
    }
}
