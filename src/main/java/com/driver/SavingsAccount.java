package com.driver;

public class SavingsAccount extends BankAccount {
    private double rate;
    private double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name, balance, 0); // minimum balance is 0 by default
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount > maxWithdrawalLimit) {
            throw new Exception("Maximum Withdraw Limit Exceeded");
        } else if (amount > getBalance()) {
            throw new Exception("Insufficient Balance");
        }
        setBalance(amount);
    }

    public double getSimpleInterest(int years) {
        // Return the final amount considering that the bank gives simple interest on the current amount
        return getBalance() * (1 + rate * years);
    }

    public double getCompoundInterest(int times, int years) {
        // Return the final amount considering that the bank gives compound interest on the current amount
        return getBalance() * Math.pow((1 + rate / times), times * years);
    }
}
