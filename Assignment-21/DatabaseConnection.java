import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection
{
    public static void main(String args[]) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String db="jdbc:mysql://localhost:3306/siulibrary";
        String user="root";
        String password="Adi@0917";

        try
        {
            Connection con=DriverManager.getConnection(db,user,password);

            System.out.println("Connection Established");

            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Error: "+e.getMessage());
        }
    }
}