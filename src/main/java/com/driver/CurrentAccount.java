package com.driver;

import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        if(balance<5000)  throw new Exception("Insufficient Balance");
        this.tradeLicenseId=tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        String check = this.tradeLicenseId;
        HashMap<Character,Integer>fmap=new HashMap<>();
        int n=check.length();
        int maxFreq=0;
        for(int i=0;i<n;i++){
            char c = check.charAt(i);
            fmap.put(c,fmap.getOrDefault(c,0)+1);
            if(fmap.get(c)>maxFreq){
                maxFreq=fmap.get(c);
            }
        }
        if(maxFreq>=((n/2)+1))   throw new Exception("Valid License can not be generated");
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }
}