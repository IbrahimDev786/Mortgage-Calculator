import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        System.out.println("_Please use ONLY number characters_");

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nPrincipal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = scanner.nextFloat();
        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;

        System.out.print("Period (in Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        String mortgageFormatted =  NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("\nMortgage: " + mortgageFormatted);









    }

}
