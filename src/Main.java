import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        bank.loadAccounts("accounts.dat");

        while (true) {
            System.out.println("\nWelcome to the banking system");
            System.out.println("1. Create account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check balance");
            System.out.println("5. Exit");
            System.out.println("6. Admin options");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Create account
                    System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();

                    System.out.print("Enter your name: ");
                    String accountName = scanner.next();

                    System.out.print("Enter starting amount: ");
                    double accountBalance = scanner.nextDouble();

                    bank.createAccount(accountNumber, accountName, accountBalance);
                    break;

                case 2:
                    // Deposit
                    System.out.print("Enter account number: ");
                    int accNumForDeposit = scanner.nextInt();

                    BankAccount accountForDeposit = bank.findAccount(accNumForDeposit);
                    if (accountForDeposit != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = scanner.nextDouble();
                        accountForDeposit.deposit(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    // Withdraw
                    System.out.print("Enter account number: ");
                    int accNumForWithdraw = scanner.nextInt();

                    BankAccount accountForWithdraw = bank.findAccount(accNumForWithdraw);
                    if (accountForWithdraw != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        accountForWithdraw.withdraw(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    // Check balance
                    System.out.print("Enter account number: ");
                    int accNumForCheck = scanner.nextInt();

                    BankAccount accountForCheck = bank.findAccount(accNumForCheck);
                    if (accountForCheck != null) {
                        System.out.println("Current balance: €" + String.format("%.2f", accountForCheck.getBalance()));
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    // Admin options
                    bank.listAccounts("accounts.dat");
                    break;

                case 5:
                    // Exit
                    bank.saveAccounts("accounts.dat");
                    System.out.println("Goodbye :)");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
