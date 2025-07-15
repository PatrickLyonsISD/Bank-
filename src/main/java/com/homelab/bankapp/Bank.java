package com.homelab.bankapp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    // Stores all the bank accounts in memory
    private List<BankAccount> accounts = new ArrayList<>();

    // Create a new com.homelab.bankapp.BankAccount and add it to the list
    public BankAccount createAccount(int accountNumber, String accountName, double accountBalance) {
        BankAccount newAccount = new BankAccount(accountNumber, accountName, accountBalance);
        accounts.add(newAccount);
        System.out.println("Account created for: " + accountName);
        return newAccount;
    }


    // Find an account by its account number (String)
    public BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        System.out.println("Account number " + accountNumber + " not found.");
        return null;
    }

    // Save the current list of accounts to a file
    public void saveAccounts(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(accounts); // write whole list
            System.out.println("Accounts saved successfully");
        } catch (Exception e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    // Load list of accounts from file
    public void loadAccounts(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            this.accounts = (List<BankAccount>) in.readObject();
            System.out.println("Accounts loaded successfully");
        } catch (Exception e) {
            System.out.println("No previous data found, starting fresh");
            this.accounts = new ArrayList<>(); // fallback to empty list
        }
    }

    // Read and print accounts from file
    public void listAccounts(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            List<BankAccount> accounts = (List<BankAccount>) in.readObject();

            if (accounts.isEmpty()) {
                System.out.println("No accounts in file");
                return;
            }

            System.out.println("====== com.homelab.bankapp.Bank accounts from file =======");
            for (BankAccount account : accounts) {
                System.out.println(account);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading accounts: " + e.getMessage());
        }
    }
}
