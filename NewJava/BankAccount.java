import java.util.*;
class BankAccount
{
    private double balance;
    private String name;
    private int customerid;
    private ArrayList<String> transactions = new ArrayList<>();

    BankAccount(String n, double b, int id)
    {
        name = n;
        balance = b;
        customerid=id;
    }

    void deposit(double amount)
    {
        if(amount<=0)
        {
            System.out.println("Invalid amount");
            return;
        }
        balance += amount;
        String t="Deposited: " + amount;
        transactions.add(t);
        summary();
    }

    void withdraw(double amount)
    {
        if (amount <= 0)
        {
            System.out.println("Invalid amount");
            return;
        }
        else if (balance < amount)
        {
            System.out.println("Insufficient balance");
            return;
        } 
        balance -= amount;
        String t="Withdrew: " + amount;
        transactions.add(t);
        summary();
    }

    void summary()
    {
        System.out.println("Account holder: " + name);
        System.out.println("Customer ID: " + customerid);
        System.out.println("Balance: " + balance);
    }

    void showTransactionHistory()
    {
        System.out.println("Transaction History:");
        for (String t : transactions)
        {
            System.out.println(t);
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to HDFC Bank Portal: ");
        System.out.println("Enter Customer ID: ");
        int cid=sc.nextInt();
        BankAccount acc1= new BankAccount("Aditya Nair", 100000.0, cid);
        
        while(true)
        {
            System.out.println("\nOperations:\n1. Deposit\n2. Withdraw\n3. Summary\n4. Show Transaction History\n5. Exit\n");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            if(choice == 5)
            {
                System.out.println("Exiting...");
                break;
            }
            switch(choice)
            {
                case 1:
                    System.out.println("Enter amount to deposit: ");
                    double da = sc.nextDouble();
                    acc1.deposit(da);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw: ");
                    double wa = sc.nextDouble();
                    acc1.withdraw(wa);
                    break;
                case 3:
                    acc1.summary();
                    break;
                case 4:
                    acc1.showTransactionHistory();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
       }
       sc.close();
    }
}
    