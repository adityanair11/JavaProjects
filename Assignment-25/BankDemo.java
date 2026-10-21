
class Bank
{
    int balance=1000;

    synchronized void deposit(int amount)
    {
        balance=balance+amount;
        System.out.println("Deposited: "+amount);
        System.out.println("Balance: "+balance);
    }

    synchronized void withdraw(int amount)
    {
        if(balance>=amount)
        {
            balance=balance-amount;
            System.out.println("Withdrawn: "+amount);
            System.out.println("Balance: "+balance);
        }
        else
        {
            System.out.println("Insufficient balance");
        }
    }
}

class DepositThread extends Thread
{
    Bank b;

    DepositThread(Bank b)
    {
        this.b=b;
    }

    public void run()
    {
        b.deposit(500);
    }
}

class WithdrawThread extends Thread
{
    Bank b;

    WithdrawThread(Bank b)
    {
        this.b=b;
    }

    public void run()
    {
        b.withdraw(300);
    }
}

public class BankDemo
{
    public static void main(String args[])
    {
        Bank b=new Bank();

        DepositThread t1=new DepositThread(b);
        WithdrawThread t2=new WithdrawThread(b);

        t1.start();
        t2.start();

        try
        {
            t1.join();
            t2.join();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }

        System.out.println("Final Balance: "+b.balance);
    }
}
