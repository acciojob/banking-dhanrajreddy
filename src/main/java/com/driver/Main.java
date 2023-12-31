package com.driver;

public class Main {
    public static void main(String[] args) throws Exception{
        BankAccount ba=new BankAccount();
        String accountNumber= ba.generateAccountNumber(8,7);
        System.out.println(accountNumber);
    }
}