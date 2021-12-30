package lesson02.Statements;

public class Statements08 {
    public static void main(String[] args) {
        int[] even = {0,1,2,3,4,5,6,7,8,9,10};
        for (int i = 0; i < even.length; i++){
            if(even[i] % 2 == 0){
                System.out.println(even[i]);
            }
        }

    }
}
