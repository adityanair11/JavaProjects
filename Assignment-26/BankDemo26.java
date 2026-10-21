
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

class DepositTask implements Runnable
{
    Bank b;

    DepositTask(Bank b)
    {
        this.b=b;
    }

    public void run()
    {
        b.deposit(500);
    }
}

class WithdrawTask implements Runnable
{
    Bank b;

    WithdrawTask(Bank b)
    {
        this.b=b;
    }

    public void run()
    {
        b.withdraw(300);
    }
}

public class BankDemo26
{
    public static void main(String args[])
    {
        Bank b=new Bank();

        Thread t1=new Thread(new DepositTask(b));
        Thread t2=new Thread(new WithdrawTask(b));

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
