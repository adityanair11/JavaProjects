
interface Product
{
    void display();
}

class Electronic implements Product
{
    String name;
    double price;

    Electronic(String n, double p)
    {
        name = n;
        price = p;
    }

    public void display()
    {
        System.out.println("\nElectronic Product");
        System.out.println("Name : " + name);
        System.out.println("Price : " + price);
    }
}

class Clothing implements Product
{
    String name;
    double price;

    Clothing(String n, double p)
    {
        name = n;
        price = p;
    }

    public void display()
    {
        System.out.println("\nClothing Product");
        System.out.println("Name : " + name);
        System.out.println("Price : " + price);
    }
}

class Grocery implements Product
{
    String name;
    double price;

    Grocery(String n, double p)
    {
        name = n;
        price = p;
    }

    public void display()
    {
        System.out.println("\nGrocery Product");
        System.out.println("Name : " + name);
        System.out.println("Price : " + price);
    }
}

public class ProductMain
{
    public static void main(String args[])
    {
        Electronic e = new Electronic("Laptop", 65000);
        Clothing c = new Clothing("T-Shirt", 999);
        Grocery g = new Grocery("Rice", 750);

        e.display();
        c.display();
        g.display();
    }
}