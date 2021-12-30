package lesson02.Statements;

public class Statements02 {
    public static void main(String[] args) {
        int[] num = {2, 5, 9};

        if( num[0] > num[1]){
            System.out.println("First one is bigger");
        } else if ( num[1] > num[0]){
            System.out.println("Second one is bigger");
        } else {
            System.out.println("Both are equal");
        }
    }
}
