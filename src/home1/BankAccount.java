package home1;/*
 Programmer: Artem Pasichnyk
 Course: SDT 202 Design and Analysis of Data Structures and Algorithms
 Due Date: February 10, 2026, 11:59 pm
 Time Spent: 30 minutes

 Description: Implementation of a BankAccount ADT.
 Supports deposits, withdrawals, and balance inquiries.
 AI Tool Statement: For explaining and checking for all standards that I have.
 */

public class BankAccount {
    private double currentBalance;

    /*
     Initializes account with zero balance.
     */
    public BankAccount() {
        currentBalance = 0.0;
    }

    /*
     Adds the specified amount to the balance.
     */
    public void deposit(double amount) {
        if (amount > 0) {
            currentBalance = currentBalance + amount;
        }
    }

    /*
     Subtracts the specified amount from the balance.
     */
    public void withdraw(double amount) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance = currentBalance - amount;
        }
    }

    /*
     Returns the current balance.
     */
    public double balance() {
        return currentBalance;
    }

    public static class BankAccountClient {
        public static void main(String[] args) {
            runBankDemo();
        }

        /*
         Tests the BankAccount ADT operations.
         */
        public static void runBankDemo() {
            BankAccount myAccount = new BankAccount();

            myAccount.deposit(100.0);
            myAccount.withdraw(30.0);

            System.out.print("Final Balance: ");
            System.out.println(myAccount.balance());
        }
    }
}
