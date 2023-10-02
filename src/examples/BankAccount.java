public class BankAccount {
    public double balance;
    public int number;

    public BankAccount(double balance){
        this.balance = balance;
    }

    public BankAccount() {
        balance = 0.0;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    public double getBalance(){
        return balance;
    }
}
