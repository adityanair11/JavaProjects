import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class HospitalLogin
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc=new Scanner(System.in);

        Class.forName("com.mysql.cj.jdbc.Driver");

        String db="jdbc:mysql://localhost:3306/siulibrary";
        String user="root";
        String password="Adi@0917";

        try
        {
            Connection con=DriverManager.getConnection(db,user,password);

            System.out.println("Connection Established");

            System.out.print("Enter Login ID: ");
            String id=sc.next();

            System.out.print("Enter Password: ");
            String pass=sc.next();

            String query="select * from HospitalStaff where loginid=? and password=?";

            PreparedStatement myStmt=con.prepareStatement(query);

            myStmt.setString(1,id);
            myStmt.setString(2,pass);

            ResultSet rs=myStmt.executeQuery();

            if(rs.next())
            {
                String role=rs.getString("role");

                System.out.println("Login Successful");
                System.out.println("Access Granted");
                System.out.println("Role: "+role);
            }
            else
            {
                System.out.println("Invalid Login ID or Password");
                System.out.println("Access Denied");
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