interface Transaction
{
    void transfer(BankAccount toAccount, double amount);
}

abstract class BankAccount implements Transaction
{
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

public void deposit(double amount)
{
    if(amount > 0)
    {
        balance += amount;
        System.out.println("The amount deposited: "+amount);
        System.out.println("The Total balance "+balance);
        System.out.println();
    }
    else
    {
        System.out.println("Enter valid amount!!!");
        System.out.println();
    }
}

public abstract void withdraw(double amount);

    @Override
    public void transfer(BankAccount toAccount, double amount)
{
    if(amount>0 && balance >= amount)
    {
        this.withdraw(amount);
        toAccount.deposit(amount);
        System.out.println("Transferred $"+amount+" To "+ toAccount.accountNumber);
        System.out.println();
    }
    else
    {
        System.out.println("Insufficient Funds, Check your balance and try again!!!");
        System.out.println();
    }
}
}

 class SavingsAccount extends BankAccount
 {
    public SavingsAccount(String accountNumber, double balance)
    {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount)
    {
        if(balance - amount >= 500)
        {
            balance -= amount;
            System.out.println("The amount withdrawn: "+amount);
            System.out.println("The Remaining balance: "+balance);
            System.out.println();
        }
        else
        {
            System.out.println("The account balance is below $500, withdrawal failed!!!");
            System.out.println();
        }
    }

 }
 class CurrentAccount extends BankAccount
 {
    private static final double overlimit= -5000.0;
    public CurrentAccount(String accountNumber, double balance)
    {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount)
    {
        if(balance - amount >= overlimit)
        {
            balance -= amount;
            System.out.println("The amount withdrawn: "+amount);
            System.out.println("The Remaining balance: "+balance);
            System.out.println();
        }
        else
        {
            System.out.println("Overdraft Limit exceeded, withdrawal failed!!!");
        }
    }
 }
 
 public class BankingSystem
 {
    public static void main(String[] args) 
    {
        BankAccount savings = new SavingsAccount("SBI001",10000);
        BankAccount current = new CurrentAccount("SBI123",12000);
        savings.withdraw(5000);
        current.withdraw(14000);
        savings.deposit(1000);
        savings.transfer(current, 4000);
        current.transfer(savings, 2000);
        savings.withdraw(5000);

        
    }
 }