package Abstraction_6_LoanApp;

public class Slice implements LoanApp {
    int creditScore;
    int approvedAmount;
    int borrowedAmount;
    int repaidAmount;
    boolean loanPaid;

    Slice(int creditScore, int loanAmount) {
        this.creditScore = creditScore;
        this.approvedAmount = 0;
        this.borrowedAmount = 0;
        this.repaidAmount = 0;
        this.loanPaid = false;
        approve(loanAmount, creditScore);
    }

    @Override
    public void borrow(int money) {
        if (money <= approvedAmount - borrowedAmount) {
            borrowedAmount += money;
            System.out.println(money + " is borrowed successfully");
        } else {
            System.out.println("Insufficient loan amount available to borrow " + money);
        }
    }

    @Override
    public void approve(int money, int creditScore) {
        if (money <= creditScore * 120) {
            approvedAmount = money;
            System.out.println(money + " can be approved.");
        } else {
            System.out.println(money + " cannot be approved.");
        }
    }

    @Override
    public void repay(int money) {
        if (borrowedAmount > 0) {
            repaidAmount += money;
            borrowedAmount -= money;
            System.out.println(money + " is repaid successfully.");
            if (borrowedAmount == 0) {
                loanPaid = true;
                System.out.println("Loan has been fully repaid!");
            } else {
                System.out.println("Pending loan amount: " + borrowedAmount);
            }
        } else {
            System.out.println("No loan to repay.");
        }
    }

    @Override
    public int pendingAmount() {
        return borrowedAmount;
    }

    @Override
    public boolean isLoanPaid() {
        return loanPaid;
    }
}