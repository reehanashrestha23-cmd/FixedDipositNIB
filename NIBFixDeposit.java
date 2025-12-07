import java.util.Scanner;

/**
 * 
 * 
 * @author (your name)
 * @version (a version number or a date)
 */

public class NIBFixDeposit {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean repeat = true;

        while (repeat) {

            System.out.print("Enter deposit amount: ");
            double principalAmount = input.nextDouble();

            if (principalAmount < 1000) {
                System.out.println("Minimum required deposit is 1000.\n");
                continue;
            }

            System.out.print("Enter annual interest rate (8-12): ");
            double interestRate = input.nextDouble();

            System.out.print("Enter investment period in years (max 5): ");
            int durationYears = input.nextInt();

            if (durationYears > 5)
                durationYears = 5;

            double monthlyRate = interestRate / 12 / 100;
            int totalMonths = durationYears * 12;

            double maturityValue = principalAmount * Math.pow(1 + monthlyRate, totalMonths);

            double processingFee = maturityValue * 0.005;
            double finalAmount = maturityValue - processingFee;

            System.out.println("\n====== DEPOSIT DETAILS ======");
            System.out.println("Maturity Amount      : " + maturityValue);
            System.out.println("Processing Fee       : " + processingFee);
            System.out.println("Final Amount Received: " + finalAmount);
            System.out.println("==============================");

            System.out.print("\nCalculate again? (true/false): ");
            repeat = input.nextBoolean();
        }
    }
}