package Assignment19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class StudentRecords
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

            String query="select * from Student";

            Statement myStmt=con.createStatement();

            ResultSet rs=myStmt.executeQuery(query);

            System.out.println("\nStudent Records");
            System.out.println("-----------------------------");

            while(rs.next())
            {
                System.out.println("Student ID : "+rs.getInt("Stid"));
                System.out.println("Name       : "+rs.getString("Sname"));
                System.out.println("Email      : "+rs.getString("Email"));
                System.out.println("Member ID  : "+rs.getInt("Memid"));
                System.out.println("Department : "+rs.getInt("Deptid"));
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
