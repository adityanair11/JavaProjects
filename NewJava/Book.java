public class Book 
{
    String title;
    String author;
    double price;
    Book()
    {
      title="";
      author="";
      price=0;
    }

    Book(String t, String a)
    {
        this.title=t;
        this.author=a;
    }

    Book(String t, String a, double p)
    {
        this.title=t;
        this.author=a;
        this.price=p;
    }

    void display()
    {
        System.out.println("Title: "+this.title);
        System.out.println("Author: "+this.author);
        System.out.println("Price: $"+this.price);
        System.out.println();
    }

    public static void main(String args[])
    {
        Book obj1= new Book();
        Book obj2= new Book("Odssey", "Mark Blanc");
        Book obj3= new Book("Odssey", "Mark Blanc", 60.5);
        obj1.display();
        obj2.display();
        obj3.display();

    }
}
