import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        System.out.println("_Please use ONLY number characters_");

        int principal = 0;
        float monthlyInterestRate = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nPrincipal: ");
            principal = scanner.nextInt();
            if (principal >= 10_000 && principal <= 500_000)
                break;
            System.out.print("\nPlease enter a value between 10,000 & 500,000");

        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterestRate = scanner.nextFloat();
            if (annualInterestRate >= 1 && annualInterestRate <= 25) {
                monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;
                break;
            }
            System.out.println("\nPlease enter a value between 1 & 25");
        }

        while (true) {
            System.out.print("Period (in Years): ");
            byte years = scanner.nextByte();
            if (years >= 5 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("\nPlease enter a value between 5 & 30");
        }

        double mortgage = principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("\nMortgage: " + mortgageFormatted);
    }
}
