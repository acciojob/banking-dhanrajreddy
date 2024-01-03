package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId = tradeLicenseId;
        if(balance < 5000){
            throw new Exception("Insufficient Balance");
        }
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }


    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        if(!isNumberValid(tradeLicenseId)){
            String rearrangedId = arrangeString(tradeLicenseId);
            if(rearrangedId ==tradeLicenseId){
                throw new Exception("Valid License can not be generated");
            }else{
                this.tradeLicenseId = rearrangedId;
                System.out.println("tradeLicenseId"+tradeLicenseId);
            }
        }
    }


    public boolean isNumberValid(String licenseId){
        for(int i=0; i<licenseId.length()-1; i++){
            if(licenseId.charAt(i) == licenseId.charAt(i+1)){
                return false;
            }
        }
        return true;
    }


    public String arrangeString(String s){
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[j] != chars[i - 1]) {
                        char temp = chars[j];
                        chars[j] = chars[i];
                        chars[i] = temp;
                    }
                }
            }
        }
        return  new String(chars);
    }
}