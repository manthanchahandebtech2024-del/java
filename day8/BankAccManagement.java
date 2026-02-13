import java.util.ArrayList;
import java.util.List;

// --- 1. Custom Exception Class ---
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// --- 2. Account Class ---
class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited $%.2f into account %s.\n", amount, accountNumber);
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds in account " + accountNumber);
        }
        balance -= amount;
        System.out.printf("Successfully withdrew $%.2f from account %s.\n", amount, accountNumber);
    }

    public void transfer(Account targetAccount, double amount) throws InsufficientFundsException {
        if (targetAccount == null) {
            System.out.println("Invalid target account.");
            return;
        }
        // Withdraw from current, then deposit to target
        this.withdraw(amount);
        targetAccount.deposit(amount);
        System.out.printf("Transferred $%.2f to account %s.\n", amount, targetAccount.getAccountNumber());
    }

    public void displayAccountDetails() {
        System.out.printf("Account: %s | Holder: %-15s | Balance: $%.2f\n", 
                          accountNumber, accountHolderName, balance);
    }

    public String getAccountNumber() { return accountNumber; }
}

// --- 3. Bank Class ---
class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void createAccount(String accountNumber, String accountHolderName, double initialBalance) {
        Account newAccount = new Account(accountNumber, accountHolderName, initialBalance);
        accounts.add(newAccount);
        System.out.println("New account created for " + accountHolderName);
    }

    public Account getAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public void displayAllAccounts() {
        System.out.println("\n--- All Bank Accounts ---");
        for (Account acc : accounts) {
            acc.displayAccountDetails();
        }
        System.out.println("--------------------------");
    }
}

// --- 4. Main Class ---
public class Main {
    public static void main(String[] args) {
        Bank myBank = new Bank();

        // Creating accounts
        myBank.createAccount("ACC001", "Alice Smith", 1000.00);
        myBank.createAccount("ACC002", "Bob Jones", 500.00);

        Account alice = myBank.getAccount("ACC001");
        Account bob = myBank.getAccount("ACC002");

        // Demonstrate operations
        if (alice != null && bob != null) {
            alice.deposit(250.0);
            
            try {
                // Successful withdrawal
                bob.withdraw(100.0);
                
                // Successful transfer
                System.out.println("\nExecuting transfer...");
                alice.transfer(bob, 300.0);
                
                // Attempting withdrawal that exceeds balance (Exception handling)
                System.out.println("\nAttempting over-withdrawal...");
                bob.withdraw(2000.0);
                
            } catch (InsufficientFundsException e) {
                System.err.println("Transaction Failed: " + e.getMessage());
            }
        }

        // Display final state
        myBank.displayAllAccounts();
    }
}