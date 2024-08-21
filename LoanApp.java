package Abstraction_6_LoanApp;

public interface LoanApp {
    void borrow(int money);
    void approve(int money, int creditScore);
    void repay(int money);
    int pendingAmount();
    boolean isLoanPaid();
}
