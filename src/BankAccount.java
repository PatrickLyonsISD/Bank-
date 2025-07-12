public class BankAccount {
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance = balance + amount;
        System.out.println("Deposited successfully. New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Amount taken out. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
                ", Name: " + accountName +
                ", Balance: €" + String.format("%.2f", balance);
    }

    public void transferTo(BankAccount target, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid transfer amount.");
            return;
        }
        if (this.balance >= amount) {
            this.withdraw(amount);
            target.deposit(amount);
            System.out.println("Transferred " + amount + " from " + this.accountName + " (" + this.accountNumber +
                    ") to " + target.accountName + " (" + target.accountNumber + ")");
        } else {
            System.out.println("Transfer failed: insufficient funds.");
        }
    }
}
