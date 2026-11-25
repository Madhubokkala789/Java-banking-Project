package JavaProject;

import java.util.Scanner;

// Abstraction
abstract class BankAccount {

    // Encapsulation
    private String accountHolder;
    private long accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder,
                       long accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Getter method
    public double getBalance() {
        return balance;
    }

    // Abstract method
    public abstract void accountType();

    // Display account details
    public void displayDetails() {
        System.out.println("\n----- Account Details -----");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: ");
        accountType();
        System.out.println("Available Balance: Rs. " + balance);
    }
}

// Inheritance
class SavingsAccount extends BankAccount {

    public SavingsAccount(String name, long number, double balance) {
        super(name, number, balance);
    }

    // Polymorphism (Method Overriding)
    @Override
    public void accountType() {
        System.out.println("Savings Account");
    }
}

// Main class
public class BankingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SavingsAccount account =
            new SavingsAccount("Madhu", 1234567890L, 5000);

        int choice;

        do {
            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter deposit amount: ");
                    double deposit = sc.nextDouble();
                    account.deposit(deposit);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdraw = sc.nextDouble();
                    account.withdraw(withdraw);
                    break;

                case 3:
                    System.out.println("Current Balance: Rs. "
                            + account.getBalance());
                    break;

                case 4:
                    account.displayDetails();
                    break;

                case 5:
                    System.out.println("Thank you for using our bank!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
