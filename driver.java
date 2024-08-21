package Abstraction_6_LoanApp;

import java.util.Scanner;

public class driver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your credit score: ");
        int creditScore = scanner.nextInt();

        System.out.print("Enter the loan amount you wish to apply for: ");
        int loanAmount = scanner.nextInt();

        Slice loanApp = new Slice(creditScore, loanAmount);

        if (loanApp.pendingAmount() >= 0) {
            System.out.print("Enter the amount you wish to borrow: ");
            int borrowAmount = scanner.nextInt();
            loanApp.borrow(borrowAmount);

            // Loop to handle multiple repayments until the loan is fully repaid
            while (loanApp.pendingAmount() > 0) {
                System.out.print("Enter the amount you wish to repay: ");
                int repayAmount = scanner.nextInt();
                loanApp.repay(repayAmount);

                System.out.println("Pending loan amount: " + loanApp.pendingAmount());
                System.out.println("Is loan fully paid? " + loanApp.isLoanPaid());
                
                // If the loan is fully repaid, break the loop
                if (loanApp.isLoanPaid()) {
                    break;
                }
            }
        } else {
            System.out.println("No loan amount was borrowed.");
        }

        scanner.close();
    }
}
