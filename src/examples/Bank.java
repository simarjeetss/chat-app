public class Bank {
    private BankAccount[] accounts;

    public Bank(int size){
        accounts = new BankAccount[size];
        for(int i=0;i<accounts.length;i++){
            accounts[i] = new BankAccount();
        }
    }
    public void deposit(int accountNumber, double amount){
        BankAccount account = accounts[accountNumber];
        account.deposit(amount);
    }

    public void withdraw(int accountNumber, double amount){
        BankAccount account = accounts[accountNumber];
        account.withdraw(amount);
    }

    public void getBalance(int accountNumber){
        BankAccount account = accounts[accountNumber];
        account.getBalance();
    }
}
