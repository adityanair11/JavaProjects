import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class EmployeeResultSet
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

            Statement myStmt=con.createStatement();

            String query="select E.Empid,E.Empname,D.Deptname,E.Salary " +
                         "from Employee E left join Department D on E.Lid=D.Lid";

            ResultSet rs=myStmt.executeQuery(query);

            System.out.println("Employee Records");
            System.out.println("-----------------------------");

            while(rs.next())
            {
                System.out.println("Employee ID : "+rs.getInt("Empid"));
                System.out.println("Name        : "+rs.getString("Empname"));
                System.out.println("Department  : "+rs.getString("Deptname"));
                System.out.println("Salary      : "+rs.getInt("Salary"));
                System.out.println("-----------------------------");
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