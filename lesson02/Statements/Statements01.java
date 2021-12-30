package lesson02.Statements;

public class Statements01 {
    public static void main(String[] args) {
        double x = 5.20;
        double y= 15.70;
        if( x > y ){
            System.out.println(x);
        }else if( y > x ) {
            System.out.println(y);
        }else {
            System.out.println( x + y );
        }
    }
}
