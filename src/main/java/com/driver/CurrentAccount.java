package com.driver;

public class CurrentAccount extends BankAccount {
    private static final double DEFAULT_MIN_BALANCE = 5000;
    private String tradeLicenseId; // consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name, balance, DEFAULT_MIN_BALANCE);
        if (balance < DEFAULT_MIN_BALANCE) {
            throw new Exception("Insufficient Balance");
        }
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are the same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        char[] chars = tradeLicenseId.toCharArray();
        boolean isValid = true;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                isValid = false;
                break;
            }
        }

        if (!isValid) {
            // Rearrange characters to create a valid license Id
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == chars[i - 1]) {
                    for (int j = i + 1; j < chars.length; j++) {
                        if (chars[j] != chars[i - 1]) {
                            char temp = chars[j];
                            chars[j] = chars[i];
                            chars[i] = temp;
                            isValid = true;
                            break;
                        }
                    }
                }
                if (isValid) {
                    break;
                }
            }
        }

        if (!isValid) {
            throw new Exception("Valid License can not be generated");
        }

        tradeLicenseId = new String(chars);
    }
}
