
abstract class Payment
{
    double amount;

    Payment(double amount)
    {
        this.amount = amount;
    }

    abstract void makePayment();
}

class CreditCard extends Payment
{
    CreditCard(double amount)
    {
        super(amount);
    }

    void makePayment()
    {
        System.out.println("\nPayment Mode : Credit Card");
        System.out.println("Amount Paid  : " + amount + "\n");
    }
}

class UPI extends Payment
{
    UPI(double amount)
    {
        super(amount);
    }

    void makePayment()
    {
        System.out.println("\nPayment Mode : UPI");
        System.out.println("Amount Paid  : " + amount + "\n");
    }
}

public class PaymentSystem
{
    public static void main(String args[])
    {
        CreditCard c = new CreditCard(2500);
        UPI u = new UPI(1500);

        c.makePayment();
        System.out.println();

        u.makePayment();
    }
}