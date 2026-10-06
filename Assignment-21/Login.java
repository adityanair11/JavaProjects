import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc=new Scanner(System.in);

        Class.forName("com.mysql.cj.jdbc.Driver");

        String db="jdbc:mysql://localhost:3306/siulibrary";
        String user="root";
        String password="your_password";

        try
        {
            Connection con=DriverManager.getConnection(db,user,password);

            System.out.println("Connection Established");

            System.out.print("Enter Username: ");
            String username=sc.next();

            System.out.print("Enter Password: ");
            String pass=sc.next();

            String query="select * from Login where username=? and password=?";

            PreparedStatement myStmt=con.prepareStatement(query);

            myStmt.setString(1,username);
            myStmt.setString(2,pass);

            ResultSet rs=myStmt.executeQuery();

            if(rs.next())
            {
                System.out.println("Login Successful");
            }
            else
            {
                System.out.println("Invalid Username or Password");
            }

            rs.close();
            myStmt.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Error: "+e.getMessage());
        }

        sc.close();
    }
}