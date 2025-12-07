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

            System.out.print("Enter deposit amount (Min 1000): ");
            double principalAmount = input.nextDouble();

            if (principalAmount < 1000) {
                System.out.println("Minimum required deposit is Rs. 1000.\n");
                continue;
            }

            System.out.print("Enter annual interest rate (8 - 12): ");
            double interestRate = input.nextDouble();

            if (interestRate < 8 || interestRate > 12) {
                System.out.println("Interest rate must be between 8% and 12%.\n");
                continue;
            }

            System.out.print("Enter investment period in years (Max 5): ");
            int durationYears = input.nextInt();

            if (durationYears <= 0) {
                System.out.println("Investment period must be at least 1 year.\n");
                continue;
            }

            if (durationYears > 5) {
                durationYears = 5;
            }

            double monthlyRate = interestRate / 12 / 100;
            int totalMonths = durationYears * 12;

            double maturityValue = principalAmount * Math.pow(1 + monthlyRate, totalMonths);
            double processingFee = maturityValue * 0.005;
            double finalAmount = maturityValue - processingFee;

            System.out.println("\n----- DEPOSIT SUMMARY -----");
            System.out.printf("Principal Amount : Rs. %.2f%n", principalAmount);
            System.out.printf("Interest Rate    : %.2f %% %n", interestRate);
            System.out.println("Investment Years : " + durationYears);
            System.out.println("--------------------------");
            System.out.printf("Maturity Amount  : Rs. %.2f%n", maturityValue);
            System.out.printf("Processing Fee   : Rs. %.2f%n", processingFee);
            System.out.println("--------------------------");
            System.out.printf("Final Amount     : Rs. %.2f%n", finalAmount);
            System.out.println("--------------------------");

            System.out.print("\nCalculate again? (true / false): ");
            repeat = input.nextBoolean();
        }

        System.out.println("\nThank you for using the NIB Fixed Deposit Calculator.");
        input.close();
    }
}