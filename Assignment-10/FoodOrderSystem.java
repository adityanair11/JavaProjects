abstract class FoodOrder
{
    double amount;

    FoodOrder(double amount)
    {
        this.amount = amount;
    }

    abstract void calculateBill();
}

class DineInOrder extends FoodOrder
{
    DineInOrder(double amount)
    {
        super(amount);
    }

    void calculateBill()
    {
        double total = amount + (amount * 0.10);

        System.out.println("\nOrder Type : Dine In");
        System.out.println("Total Bill : " + total);
    }
}

class TakeAwayOrder extends FoodOrder
{
    TakeAwayOrder(double amount)
    {
        super(amount);
    }

    void calculateBill()
    {
        double total = amount + 30;

        System.out.println("Order Type : Take Away");
        System.out.println("Total Bill : " + total);
    }
}

public class FoodOrderSystem
{
    public static void main(String args[])
    {
        DineInOrder d = new DineInOrder(1000);
        TakeAwayOrder t = new TakeAwayOrder(1000);

        d.calculateBill();
        System.out.println();

        t.calculateBill();
    }
}