
import java.util.*;

class BankAccount
{
    private double balance;
    private String name;
    private final int accountNumber;
    private ArrayList<String> transactions = new ArrayList<>();

    BankAccount(String n, double b, int accountNumber)
    {
        name = n;
        balance = b;
        this.accountNumber = accountNumber;
    }

    void deposit(double amount)
    {
        if(amount <= 0)
        {
            System.out.println("Invalid amount");
            return;
        }

        balance += amount;
        transactions.add("Deposited: " + amount);

        System.out.println("Amount deposited successfully.");
        summary();
    }

    void withdraw(double amount)
    {
        if(amount <= 0)
        {
            System.out.println("Invalid amount");
            return;
        }

        if(balance < amount)
        {
            System.out.println("Insufficient balance");
            return;
        }

        balance -= amount;
        transactions.add("Withdrew: " + amount);

        System.out.println("Amount withdrawn successfully.");
        summary();
    }

    void summary()
    {
        System.out.println("\nAccount Holder : " + name);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance        : " + balance);
    }

    void showTransactionHistory()
    {
        System.out.println("\nTransaction History:");

        if(transactions.isEmpty())
        {
            System.out.println("No transactions found.");
            return;
        }

        for(String t : transactions)
        {
            System.out.println(t);
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to HDFC Bank Portal");

        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();

        BankAccount acc = new BankAccount("Aditya Nair", 100000.0, accountNumber);

        while(true)
        {
            System.out.println("\nChoose an Operation");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Account Summary");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    acc.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    acc.withdraw(withdrawAmount);
                    break;

                case 3:
                    acc.summary();
                    break;

                case 4:
                    acc.showTransactionHistory();
                    break;

                case 5:
                    System.out.println("Thank you for using HDFC Bank Portal.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}