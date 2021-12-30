package lesson02.Statements;

public class StatementsFactorial {
    public static void main(String[] args) {
        int num = 5;
        long factorial = 1;
        for (int i = num; i > 0; i--){
            factorial *= i;
        }
        System.out.println(factorial);
    }
}
