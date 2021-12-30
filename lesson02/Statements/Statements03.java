package lesson02.Statements;

public class Statements03 {
    public static void main(String[] args) {
//        A)
        for (int i = 1; i <= 10; i++){
            System.out.print(" " + i);
        }
        System.out.println();
//        B)
        int n = 1;
        while (n <= 10){
            System.out.print(" " + n);
            n++;
        }
        System.out.println();
//        C)
        for (int i = 30; i <= 50; i++){
            if( i % 2 == 0 ){
                System.out.print(" " + i);
            }
        }
        System.out.println();
//        D)
        for (int i = 20; i <= 40; i++){
            if( i % 2 != 0 ){
                System.out.print(" " + i);
            }
        }
    }
}
