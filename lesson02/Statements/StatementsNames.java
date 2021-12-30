package lesson02.Statements;

import java.util.Arrays;

public class StatementsNames {
    public static void main(String[] args) {
        String names = "Bar Shir Mila Ari Lital";
        char firstLetter;
        String [] arrayNames = names.split(" "); // Took String and convert to Array
        System.out.println(Arrays.toString(arrayNames)); // Printing Array
        for (int i = 0; i < arrayNames.length; i++){
            System.out.println(arrayNames[i]);
            firstLetter = arrayNames[i].charAt(0); // First Character (letter)
            System.out.println(firstLetter);

        }
    }
}
