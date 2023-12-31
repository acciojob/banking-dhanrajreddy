package com.driver;
import java.net.StandardSocketOptions;
public class BankAccount {
    private String name;
    private double balance;
    private double minBalance;
    BankAccount(){}
    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }
    public String generateAccountNumber(int digits, int sum) throws Exception {
        // Each digit of an account number can lie between 0 and 9 (both inclusive)
        // Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        // If it is not possible, throw "Account Number can not be generated" exception

        // Implement your logic to generate the account number here
        String number="";
        int temp=sum;
        int num=0;
        int countSum=0;
        int maxSum=9*digits;
        if(sum>maxSum || sum<0)
            throw new Exception("Account Number can not be generated");
        if(digits==1)
            return number+=sum;
        if(sum==0){
            for(int i=0;i<digits;i++)
                number+=0;
        }else{
            if(sum%digits==0){
                num=sum/digits;
                for(int i=0;i<digits;i++)
                    number+=num;
            }else{
                num=sum%digits;
                int num1=0;
                num1=sum-num;
                int add=0;
                add=num1/digits;
                for(int i=0;i<digits;i++){
                    if(num>0) {
                        number += (add + 1);
                        num--;
                    }else{
                        number+=add;
                    }
                }
            }

        }
        return number;
    }
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        if (balance - amount < minBalance) {
            throw new Exception("Insufficient Balance");
        }
        balance -= amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}
