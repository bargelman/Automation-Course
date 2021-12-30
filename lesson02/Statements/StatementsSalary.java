package lesson02.Statements;

import java.util.Random;

public class StatementsSalary {
    public static void main(String[] args) {
        Random rand = new Random();
        double randomSalary = rand.nextInt(50000);
        randomSalary+= 1;
        System.out.println(randomSalary);
        if (randomSalary >= 5000 && randomSalary <= 10000){
            randomSalary = randomSalary * 0.9;
        }else if (randomSalary >= 10000 && randomSalary <= 20000){
            randomSalary = randomSalary * 0.8;
        }else if (randomSalary >= 20000){
            randomSalary = randomSalary * 0.7;
        }
        System.out.println(randomSalary);
    }
}
