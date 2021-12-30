package lesson02.Statements;

public class Statements10 {
    public static void main(String[] args) {
        String[] reverse = {"o","l","l","e","H"};
        int count = reverse.length - 1;
        do {
            System.out.print(reverse[count]);
            count--;
        }
        while ( count >= 0);
    }
}
