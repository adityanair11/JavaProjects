import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class prepared_statement
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc=new Scanner(System.in);

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con=DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/SIULibrary",
            "root",
            "your_password"
        );

        String query="insert into Demo(Sname,Sphone,Scity) values(?,?,?)";

        PreparedStatement myStmt=con.prepareStatement(query);

        System.out.println("Enter Name:");
        myStmt.setString(1,sc.next());

        System.out.println("Enter Phone:");
        myStmt.setInt(2,sc.nextInt());

        System.out.println("Enter City:");
        myStmt.setString(3,sc.next());

        myStmt.executeUpdate();

        System.out.println("Data Inserted");

        myStmt.close();
        con.close();
        sc.close();
    }
}