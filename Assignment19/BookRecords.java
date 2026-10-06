package Assignment19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class BookRecords
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

            String query="select B.Bid,B.Bname,count(N.Bnid) as Quantity,B.Price " +
                         "from Books B left join Noofcopies N on B.Bid=N.Bid " +
                         "group by B.Bid,B.Bname,B.Price";

            Statement myStmt=con.createStatement();

            ResultSet rs=myStmt.executeQuery(query);

            System.out.println("\nBook Details");
            System.out.println("-----------------------------");

            while(rs.next())
            {
                System.out.println("Book ID   : "+rs.getInt("Bid"));
                System.out.println("Book Name : "+rs.getString("Bname"));
                System.out.println("Quantity  : "+rs.getInt("Quantity"));
                System.out.println("Price     : "+rs.getInt("Price"));
                System.out.println("-----------------------------");
            }

            rs.close();
            myStmt.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Connection Failed");
        }
    }
}