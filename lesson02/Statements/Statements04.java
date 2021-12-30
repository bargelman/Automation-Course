package lesson02.Statements;

public class Statements04 {
    public static void main(String[] args) {
        String [] countries = {"Austria", "Germany", "Canada", "Peru", "Israel"};
//        A)
        for(int i=0; i < countries.length; i++) {
            System.out.print(" " + countries[i]);
        }
        System.out.println();

//        B)
        for(int i=0; i < countries.length; i++) {
            if(countries[i].equals("Israel")){
                System.out.println(countries[i]);
            }
        }

//        C)
            if (countries[2].equals("China")) {
                System.out.println("Yes, it is there");
            }else {
                System.out.println("No, Sorry...");
            }

//        D)
            System.out.println(countries[0].length());
    }
}
