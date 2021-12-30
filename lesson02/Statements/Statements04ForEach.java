package lesson02.Statements;

public class Statements04ForEach {
    public static void main(String[] args) {
        String [] countries = {"Austria", "Germany", "Canada", "Peru", "Israel"};
        for (String country: countries) {
            System.out.print(" " + country);
            if(country.equals("Israel")) {
                System.out.println();
                System.out.println(country);
            }
        }
    }
}
