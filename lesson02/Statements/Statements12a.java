package lesson02.Statements;

public class Statements12a {
    public static void main(String[] args) {
        int number = 9;
        boolean isPrime = true;
        for (int i = 2; i <= number / 2; i++) {
            if(number % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime)
            System.out.println("The number: " + number + " is a Prime Number");
        else
            System.out.println("The number: " + number + " is NOT a Prime Number");
    }
    }

