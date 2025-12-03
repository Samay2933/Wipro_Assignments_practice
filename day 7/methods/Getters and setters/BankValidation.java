import java.util.*;

class BankAccount {
    private String holderName;
    private int accountNumber;
    private int balance;

    // Getter for name
    public String getName() {
        return holderName;
    }

    // Getter for account number
    public int getAccountNumber() {
        return accountNumber;
    }

    // Getter for balance
    public int balance() {
        return balance;
    }

    // Setter for name
    public void setName(String holderName) {
        this.holderName = holderName;
    }

    // Setter for account number
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Validate account number
    public boolean isValidAccount(int inputAccountNumber) {
        return this.accountNumber == inputAccountNumber;
    }

    public boolean deposit(int inputAccountNumber, int amount) {
        if (isValidAccount(inputAccountNumber)) {
            if (amount > 0) {
                balance += amount;
                return true;
            }
        }
        return false;
    }

    public boolean withdraw(int inputAccountNumber, int amount) {
        if (isValidAccount(inputAccountNumber)) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            }
        }
        return false;
    }

    public void DisplayInfo() {
        System.out.println("Account Holder: " + holderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("----------------------");
    }
}

public class bankvalidation {
    public static void main(String[] args) {
        int inputAccNo;
        BankAccount acc = new BankAccount();
        acc.setName("Sam");
        acc.setAccountNumber(123456789);

        inputAccNo = 123456789;   // correct account number
        if (acc.deposit(inputAccNo, 700)) {
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit denied.");
        }

        // inputAccNo = 111111111;       //  incorrect account number
        // if (acc.withdraw(inputAccNo, 900)) {
        //     System.out.println("Withdrawal successful.");
        // } else {
        //     System.out.println("Withdrawal denied.");
        // }

        acc.DisplayInfo();
    }
}
