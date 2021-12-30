package lesson02.Statements;

import java.util.Random;

public class Statements06 {
    public static void main(String[] args) {
        String[] job = {"Teacher", "Bank Teller", "QA", "Average Salary"};
        String randomJob = (job[new Random().nextInt(job.length)]);
        System.out.println(randomJob);
        switch (randomJob){
            case "Teacher":
                System.out.println("5,000$");
                break;
            case "Bank Teller":
                System.out.println("10,000$");
                break;
            case "QA":
                System.out.println("15,000$");
                break;
            case "Average Salary":
                System.out.println("9,100$");
        }
    }
}
