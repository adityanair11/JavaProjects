import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EmployeeCRUD
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

            int choice;

            while(true)
            {
                System.out.println("\n1. Insert Employee");
                System.out.println("2. Display Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");

                System.out.print("Enter choice: ");
                choice=sc.nextInt();

                if(choice==1)
                {
                    System.out.print("Enter Employee ID: ");
                    int id=sc.nextInt();

                    System.out.print("Enter Employee Name: ");
                    String name=sc.next();

                    System.out.print("Enter Email: ");
                    String email=sc.next();

                    System.out.print("Enter Salary: ");
                    int salary=sc.nextInt();

                    System.out.print("Enter Library ID: ");
                    int lid=sc.nextInt();

                    String query="insert into Employee(Empid,Empname,Email,Salary,Lid) values(?,?,?,?,?)";

                    PreparedStatement myStmt=con.prepareStatement(query);

                    myStmt.setInt(1,id);
                    myStmt.setString(2,name);
                    myStmt.setString(3,email);
                    myStmt.setInt(4,salary);
                    myStmt.setInt(5,lid);

                    myStmt.executeUpdate();

                    System.out.println("Employee Inserted");
                }

                else if(choice==2)
                {
                    String query="select * from Employee";

                    PreparedStatement myStmt=con.prepareStatement(query);

                    ResultSet rs=myStmt.executeQuery();

                    System.out.println("\nEmployee Records");

                    while(rs.next())
                    {
                        System.out.println(
                            rs.getInt("Empid")+" "+
                            rs.getString("Empname")+" "+
                            rs.getString("Email")+" "+
                            rs.getInt("Salary")+" "+
                            rs.getInt("Lid")
                        );
                    }
                }

                else if(choice==3)
                {
                    System.out.print("Enter Employee ID: ");
                    int id=sc.nextInt();

                    System.out.print("Enter New Salary: ");
                    int salary=sc.nextInt();

                    String query="update Employee set Salary=? where Empid=?";

                    PreparedStatement myStmt=con.prepareStatement(query);

                    myStmt.setInt(1,salary);
                    myStmt.setInt(2,id);

                    myStmt.executeUpdate();

                    System.out.println("Employee Updated");
                }

                else if(choice==4)
                {
                    System.out.print("Enter Employee ID: ");
                    int id=sc.nextInt();

                    String query="delete from Employee where Empid=?";

                    PreparedStatement myStmt=con.prepareStatement(query);

                    myStmt.setInt(1,id);

                    myStmt.executeUpdate();

                    System.out.println("Employee Deleted");
                }

                else if(choice==5)
                {
                    break;
                }

                else
                {
                    System.out.println("Invalid Choice");
                }
            }

            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Connection Failed");
        }

        sc.close();
    }
}