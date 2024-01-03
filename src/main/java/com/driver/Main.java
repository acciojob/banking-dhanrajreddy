package com.driver;

public class Main {
    public static void main(String[] args)  throws Exception{
        CurrentAccount currentAccount=new  CurrentAccount("Dhanush",10000.0,"abbcdefg");
        currentAccount.validateLicenseId();
    }
}