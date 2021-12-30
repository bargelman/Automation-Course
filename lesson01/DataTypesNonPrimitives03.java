package com.lesson01;

public class DataTypesNonPrimitives03 {
    public static void main(String[] args) {
        String[] family = {"Bar", "Shir", "Mila", "Ari"};
//        A)
        System.out.println(family[0].toUpperCase());
        System.out.println(family[1].toUpperCase());
        System.out.println(family[2].toUpperCase());
        System.out.println(family[3].toUpperCase());

//        B)
        System.out.println(family[0].length());

//        C)
        String momAndDad = family[2].concat(" " + family[3]);
        System.out.println(momAndDad);

//        D)
        String first = family[0];
        String second = family[1];
        String third = family[2];
        String fourth = family[3];
        System.out.println(first.charAt(0));
        System.out.println(second.charAt(0));
        System.out.println(third.charAt(0));
        System.out.println(fourth.charAt(0));
    }
}
