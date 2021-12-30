package lesson02.Operators;
import java.util.Random;
public class Operators {
    public static void main(String[] args) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(25);
        System.out.println("The Random Number is: " + randomNumber);
        int num = randomNumber % 2 == 0 ? randomNumber : -1 ;
        String oddOrEven = num == randomNumber ? "Even" : "Odd";
        System.out.println(oddOrEven);
    }
}

