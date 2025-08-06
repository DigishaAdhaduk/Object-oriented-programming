class BankAccount{
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }


    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }
    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Raj Aryan", 500.0);
        System.out.println("Account Holder: " + account.getAccountHolder()); // Output: Account Holder: Raj Aryan
        System.out.println("Initial Balance: " + account.getBalance()); // Output: Initial Balance: 500.0

        account.deposit(200.0); // Output: Deposit successful. New balance: 700.0
        account.checkBalance(); // Output: Current balance: 700.0

        account.withdraw(100.0); // Output: Withdrawal successful. Remaining balance: 600.0
        account.checkBalance(); // Output: Current balance: 600.0

        account.withdraw(700.0); // Output: Insufficient funds for withdrawal.
    }
}
