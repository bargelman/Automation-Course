package lesson02.Statements;

public class Statements09 {
    public static void main(String[] args) {
        int[] num = {3,5,25,30,15,60,77};
        for (int j : num) {
            if (j % 3 == 0 && j % 5 == 0) {
                System.out.println(j);
            }
        }


    }
}
