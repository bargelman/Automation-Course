package lesson02.Statements;

public class Statements11 {
    public static void main(String[] args) {
        int[] arr = {15, 2, 36, 20, 7};
//        A)
        if (arr[0] > arr[1]) {
            if (arr[0] > arr[2]) {
                System.out.println(arr[0]);
            } else {
                System.out.println(arr[2]);
            }
        } else {
            if (arr[1] > arr[2]) {
                System.out.println(arr[1]);
            } else {
                System.out.println(arr[2]);
            }
        }
//        B)
        int biggerNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > biggerNumber) {
                biggerNumber = arr[i];
            }
        }
                System.out.println(biggerNumber);
//        C)
        int sum = 0 ;
        for (int i = 0; i < arr.length; i++ ){
            sum = sum + arr[i];
        }
        System.out.println(sum);

    }
}
