// Savings Account child class
// has an interest rate
// a method to apply interest - profit 

public class SavingsAccount extends Account {

    // interest rate
    private double interestRate;

    // default constructor
    public SavingsAccount() {

        super();
    }


    public SavingsAccount(int accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    // getter function
    public double getInterestRate() {

        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {

        this.interestRate = interestRate;
    }

    public double calcInterest() {

        return balance * interestRate;
    }

    public void applyInterest() {
        double interest = calcInterest();
        System.out.printf("Interest amount %.2f added to balance%n", interest);
        deposit(interest);
    }


    public void deposit(double amount) {

        // First Check amount
        if (amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);
            System.out.printf("Current Balance is: %.2f%n", balance);

        } else {
            System.out.println("A negative amount cannot be deposited");
        }
    }


    public void withdraw(double amount) {

        // Same check
        if (amount > 0) {
            // Check sufficient balance
            if ((amount) <= balance) {
                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                System.out.printf("Current Balance is: %.2f%n", balance);
            }
        } else {
            System.out.println("Negative amount cannot be withdrawn!");
        }
    }
}
