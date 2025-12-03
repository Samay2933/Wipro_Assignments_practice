/*
 Create a BankAccount class with private fields for account holder's name, account number, and balance. Implement methods to deposit
and withdraw money with proper validation (e.g., no overdraft, positive amounts only). Provide getters and setters for the account
holder's name and account number, but encapsulate the balance to be modified only through deposit and withdraw methods. Include a
method to display account details.
 */
import java.util.*;

class BankAccount{
    private String holderName;
    private int accountNumber;
    private int balance;

    //Getter 
    public String getName(){
        return holderName;
    }

    public int getAccountNumber(){
        return accountNumber;
    }
    public int balance(){
        return balance;
    }
    

    //Setter
    public void setName(String holderName){
        this.holderName = holderName;
    } 

    public void setAccountNumber(int accountNumber){  
        this.accountNumber = accountNumber;
    } 

    //deposite method 
    public boolean deposit(int amount){
        if(amount >0){
            balance += amount;
            return true;
        }else{
            return false;
        }
    }

    //Withdraw method 
    public boolean withdraw(int amount) {  //if private then it will show error  acc.withdraw(900);
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    //Display 
    public void DisplayInfo(){
        System.out.println("Account Holder: " + holderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("----------------------");
    }
}


public class Bank {

    public static void main(String[] args) {


        BankAccount acc = new BankAccount();

        acc.setName("Sam");
        acc.setAccountNumber(123456789);
        
        acc.deposit(700);
        acc.withdraw(900);

        acc.DisplayInfo();
        
    }
    
}


/*
 
import java.util.*;
class BankAccount { 
    private String name;
    private String acno;
    private int bal;
    public BankAccount(String name, String acno, int bal) {
        this.name = name;
        this.acno = acno;
        this.bal = bal;
    }
    public String get_name() {
        return name;
    }
    public String set_name(String name){
        this.name=name;
        System.out.println("Name Updated ");
        return name;
    }
    public String get_acno() {
        return acno;
    }
    public String set_acno(String acno){
        this.acno = acno;
        System.out.println("Acc No. Updated ");
        return acno;
    }
    public double get_bal(){
        return bal;
    }
    public void deposit(int amt){
        bal += amt;
        System.out.println("Amount Deposited: " + amt);
        System.out.println("New Balance: " + bal);
    }
    public void with(int amt){
        if (amt > bal) {
            System.out.println("Not Enough Bal");
        }
        else {
            bal -= amt;
            System.out.println("Amount Withdrawn: " + amt);
            System.out.println("New Balance: " + bal);
        }
    }
    public void display(){
        System.out.println("Account Holder Name: " + name);
        System.out.println("Account Number: " + acno);
        System.out.println("Account Balance: " + bal);
    }    
    
}
public class Main{
    public static void main(String args[]) {
        BankAccount acc = new BankAccount("Harry Potter ", "12345", 1000);
        acc.display();
        acc.deposit(500);
        acc.with(200);
        acc.set_name("Harry K Potter");
        acc.set_acno("12345");
        acc.display();
    }
}

 */


