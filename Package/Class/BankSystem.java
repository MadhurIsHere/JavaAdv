package Class;
class BankAccount{
    private double balance;

    public BankAccount(double initialBalance)
    {
        assert initialBalance>=0:"Initial Balance can not be negative";
        this.balance=initialBalance;
    }

    public void deposit(double amount)
    {
        assert amount>0:"Deposite amount must be positive";
        balance+=amount;
    }
    public void withdraw(double amount)
    {
        assert amount>0:"Amount should be positive";
        assert balance>= amount:"Balance should be greater than amount ";
        balance-=amount;
    }
    public double getBalance()
    {
        return balance;
    }
}
public class BankSystem {
    public static void main(String[] args) {
        BankAccount one=new BankAccount(10000);
        one.deposit(20000);
        System.out.println(one.getBalance());
        one.withdraw(5000);
        System.out.println(one.getBalance());
    }
}
