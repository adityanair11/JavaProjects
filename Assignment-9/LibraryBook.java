
public class LibraryBook
{
    final String isbn;
    String title;
    String author;
    double price;

    LibraryBook(String isbn, String title, String author, double price)
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display()
    {
        System.out.println("\nISBN : " + isbn);
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price : " + price + "\n");
    }

    public static void main(String args[])
    {
        LibraryBook obj = new LibraryBook("978-93-12345","Java Programming","Herbert Schildt",799);
        obj.display();
    }
}