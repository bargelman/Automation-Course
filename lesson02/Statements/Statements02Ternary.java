package lesson02.Statements;

public class Statements02Ternary {
    public static void main(String[] args) {
        int[] arr = {7, 2};
        int num = arr[0] > arr[1] ? arr[0] : arr[1];
        String bigger = num == arr[0] ? "First one is bigger" : "Second one is bigger";
        System.out.println(bigger);
        }
}
