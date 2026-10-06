import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class StudentDatabase
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

            Statement myStmt=con.createStatement();

            String query="select count(*) from Student";

            ResultSet rs=myStmt.executeQuery(query);

            if(rs.next())
            {
                System.out.println("Student Database Connected Successfully");
                System.out.println("Number of Students: "+rs.getInt(1));
            }

            rs.close();
            myStmt.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Error: "+e.getMessage());
        }
    }
}