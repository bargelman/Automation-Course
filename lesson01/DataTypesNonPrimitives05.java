package com.lesson01;

public class DataTypesNonPrimitives05 {
    public static void main(String[] args) {
        String[] words = {"Java", "is", "general", "purpose", "computer", "programing", "language"};
//        A)
        System.out.println(words[words.length-1]);
        System.out.println(words[words.length-2]);
        System.out.println(words[words.length-3]);
//        B)
        String str = "Java is general purpose computer programing language";
        String[] newStr = str.split(" ");
        System.out.println(newStr[newStr.length-1] + " " + newStr[newStr.length-2] + " " + newStr[newStr.length-3]);

    }
}
