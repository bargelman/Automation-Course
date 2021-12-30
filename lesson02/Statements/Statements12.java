package lesson02.Statements;

public class Statements12 {
    public static void main(String[] args) {
        int num = 4;
        if((num % 2 != 0) && (num % 3 != 0)){
            System.out.println(num + " " + "Is Prime Number");
        }else if ((num % 2 != 0) && (num % 3 == 0) && num <= 3){
            System.out.println(num + " " + "Is Prime Number");
        }else if ((num % 2 == 0) && (num % 3 != 0) && num <= 3){
            System.out.println(num + " " + "Is Prime Number");
        }else {
            System.out.println(num + " " + "Not a Prime Number");
        }
    }
}
