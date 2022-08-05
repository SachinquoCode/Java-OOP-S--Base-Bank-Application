import java.util.Scanner;
import java.util.ArrayList;

public class AccountServices {
    static Scanner keyboard = new Scanner(System.in);
    // Entry point of program
    public static void main(String [] args) {


        
        // Create array of Accounts

        ArrayList <Account> accounts = new ArrayList<Account>();

//        Account accounts [] = new Account[10];

        int numAccounts = 0;

        int choice;

        do {
            choice = menu();
            System.out.println();

            if(choice == 1) {
                accounts.add(numAccounts++, createAccount());
            } else if(choice == 2) {
                doDeposit(accounts, numAccounts);
            } else if(choice == 3) {
                doWithdraw(accounts, numAccounts);
            } else if(choice == 4) {
                applyInterest(accounts, numAccounts);
            } else {
                System.out.println("GoodBye!");
            }
            System.out.println();
        } while(choice != 5);
    }

    /**
     * Account choice
     */
    public static int accountMenu() {
        System.out.println("Select Account Type");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");

        int choice;
        do {
            System.out.print("Enter choice: ");
            choice = keyboard.nextInt();
        }while(choice < 1 || choice > 2);
        
        return choice;
    } 

    public static int searchAccount(ArrayList <Account> accounts , int count, int accountNumber) {

        for(int i=0; i<accounts.size(); i++) {
            if(accounts.get(i).getAccountNumber()== accountNumber) {
                return i;
            }
        }

        return -1; 
    }

    /**
     * Function to perform Deposit on a selected account
     */
    public static void doDeposit(ArrayList <Account> accounts , int count) {
        // Get the account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

        // search for account
        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0) {
            // Amount
            System.out.print("Please enter Deposit Amount: ");
            double amount = keyboard.nextDouble();

            accounts.get(index).deposit(amount);
        } else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }
    }

    public static void doWithdraw(ArrayList <Account> accounts, int count) {
        // Get the account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

        // search for account
        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0) {
            // Amount
            System.out.print("Please enter Withdraw Amount: ");
            double amount = keyboard.nextDouble();
            accounts.get(index).withdraw(amount);
        } else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }
    }

    public static void applyInterest(ArrayList <Account> accounts, int count) {
        // Get the account number
        try {
            System.out.print("\nPlease enter account number: ");
            int accountNumber = keyboard.nextInt();

            // search for account
            int index = searchAccount(accounts, count, accountNumber);

            if (index >= 0) {

                // must be instance of savings account
                if (accounts.get(index) instanceof SavingsAccount) {
                    ((SavingsAccount) accounts.get(index)).applyInterest();
                }
            } else {
                System.out.println("No account exist with AccountNumber: " + accountNumber);
            }
        }catch (NumberFormatException e){
            System.out.println("Integer only ....");
        }
    }

    /**
     * Function to create a new Account
     */
    public static Account createAccount() {
        try {
            Account account = null;
            int choice = accountMenu();
            int accountNumber;
            System.out.print("Enter Account Number: ");
            accountNumber = keyboard.nextInt();

            if (choice == 1) { // chekcing account
                System.out.print("Enter Transaction Fee: ");
                double fee = keyboard.nextDouble();
                account = new CheckingAccount(accountNumber, fee);
            } else { // Savings account

                System.out.print("Please enter Interest Rate: ");
                double ir = keyboard.nextDouble();
                account = new SavingsAccount(accountNumber, ir);
            }
            return account;
        }catch (Exception e){
            System.out.println("Integer");
            return null;
        }
    }
    /**
     * Menu to display options and get the user's selection
     * @return choice
     */
    public static int menu() {
        System.out.println("Bank Account Menu");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Apply Interest");
        System.out.println("5. Quit");

        int choice;

        do {
            System.out.print("Enter choice: ");
            choice = keyboard.nextInt();
        } while(choice < 1 || choice > 5);

        return choice;
    }
}
