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
        int digitSum=0;
        int i=0;
            while(sum>0) {
                if(number.length()>digits)
                    throw new Exception("Account number not generated");
                if (sum >= i && i >= 9) {
                    sum = sum - i;
                    number += i;
                    //System.out.println(number);
                    digitSum += i;
                }
                else if(sum> 0 && i==10)
                    i=0;
                else
                     i++;
            }
            while(number.length()!=digits){
                number+=0;
            }
        if (temp!=digitSum)
            throw new Exception("Account number not generated");
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
