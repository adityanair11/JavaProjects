package Assignment12.library;

public class Book 
{
    int bookId;
    String title;
    String author;
    double price;

    public Book(int id,String title,String author,double price)
    {
        this.bookId=id;
        this.title=title;
        this.author=author;
        this.price=price;
    }

    public void display()
    {
        System.out.println("Book ID : "+bookId);
        System.out.println("Title   : "+title);
        System.out.println("Author  : "+author);
        System.out.println("Price   : "+price);
    }  
}
