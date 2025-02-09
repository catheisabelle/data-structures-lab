// bank account class
class BankAccount {
    private String AccountNumber;
    private String AccountHolderName;
    protected double balance;

    public BankAccount(String AccountNumber, String AccountHolderName, double balance) {
        this.AccountNumber = AccountNumber;
        this.AccountHolderName = AccountHolderName;
        this.balance = balance;
    }

    // deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
        else {
            System.out.println("Error");
        }
    }

    // withdraw
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        }
        else {
            System.out.println("Error");
        }
    }

    // check balance
    public void checkBalance() {
        System.out.println("Balance: $" + balance);
    }
}

// savings account subclass
class SavingsAccount extends BankAccount {
    private double InterestRate;

    public SavingsAccount(String AccountNumber, String AccountHolderName, double balance, double InterestRate) {
        super(AccountNumber, AccountHolderName, balance); // take from parent class
        this.InterestRate = InterestRate;
    }

    // apply interest method
    public void applyInterest() {
        double interest = balance * (InterestRate / 100);
        balance += interest;
        System.out.println("Interest applied: $" + interest);
    }
}
