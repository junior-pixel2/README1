public class HomeLoan extends Expense {
  // HomeLoan

    private double purchasePrice;
    private double deposit;
    private double interestRate;
    private int months;

    public HomeLoan(double purchasePrice, double deposit, double interestRate, int months) {
        super(calculateMonthlyRepayment(purchasePrice, deposit, interestRate, months));
        this.purchasePrice = purchasePrice;
        this.deposit = deposit;
        this.interestRate = interestRate;
        this.months = months;
    }

    private static double calculateMonthlyRepayment(double purchasePrice, double deposit, double interestRate, int months) {
        double loanAmount = purchasePrice - deposit;
        double monthlyRate = (interestRate / 100) / 12;
        return (loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
    }

    @Override
    public String getDescription() {
        return "Home Loan Monthly Repayment";
    }
}
  
