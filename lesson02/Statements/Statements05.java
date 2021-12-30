package lesson02.Statements;
import java.util.Random;
public class Statements05 {
    public static void main(String[] args) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(121);
        System.out.println(randomNumber);
        if (randomNumber >= 0 && randomNumber <= 6) {
            System.out.println("Go to Kindergarten");
        } else if (randomNumber >= 7 && randomNumber <= 18) {
            System.out.println("Go to School");
        } else if (randomNumber >= 19 && randomNumber <= 67) {
            System.out.println("Go to Work");
        } else {
            System.out.println("Collecting Pension");
        }
    }
}
