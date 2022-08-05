// Checking Account
public class CheckingAccount extends Account {

    // Default Transaction Fee
    private static double FEE = 2.5;

    // default constructor
    public CheckingAccount() {

        super();
    }


    public CheckingAccount(int accountNumber, double fee) {
        super(accountNumber);
        FEE = fee;
    }


    public void deposit(double amount) {

        // First Check amount

        if( amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);

            // Apply Transaction Fee
            balance -= FEE;
            System.out.printf("Fee %.2f Applied%n", FEE);
            System.out.printf("Current Balance is: %.2f%n", balance);

        } else {
            System.out.println("A negative amount cannot be deposited");
        }
    }


    public void withdraw(double amount) {

        // Same check
        if(amount > 0) {
            // Check sufficient balance
            if((amount+FEE) <= balance) {

                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                balance -= FEE;
                System.out.printf("Fee of %.2f applied%n", FEE);
                System.out.printf("Current Balance is: %.2f%n", balance);
            }
        } else {
            System.out.println("Negative amount cannot be withdrawn!");
        }
    }
}
