import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentCRUD
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
                System.out.println("\n1. Insert Student");
                System.out.println("2. Display Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");

                System.out.print("Enter choice: ");
                choice=sc.nextInt();

                if(choice==1)
                {
                    System.out.print("Enter Student ID: ");
                    int id=sc.nextInt();

                    System.out.print("Enter Student Name: ");
                    String name=sc.next();

                    System.out.print("Enter Email: ");
                    String email=sc.next();

                    System.out.print("Enter Member ID: ");
                    int memid=sc.nextInt();

                    System.out.print("Enter Department ID: ");
                    int deptid=sc.nextInt();

                    String query="insert into Student(Stid,Sname,Email,Memid,Deptid) values(?,?,?,?,?)";

                    PreparedStatement myStmt=con.prepareStatement(query);

                    myStmt.setInt(1,id);
                    myStmt.setString(2,name);
                    myStmt.setString(3,email);
                    myStmt.setInt(4,memid);
                    myStmt.setInt(5,deptid);

                    myStmt.executeUpdate();

                    System.out.println("Student Inserted");
                }

                else if(choice==2)
                {
                    String query="select * from Student";

                    PreparedStatement myStmt=con.prepareStatement(query);

                    ResultSet rs=myStmt.executeQuery();

                    System.out.println("\nStudent Records");

                    while(rs.next())
                    {
                        System.out.println(
                            rs.getInt("Stid")+" "+
                            rs.getString("Sname")+" "+
                            rs.getString("Email")+" "+
                            rs.getInt("Memid")+" "+
                            rs.getInt("Deptid")
                        );
                    }
                }

                else if(choice==3)
                {
                    System.out.print("Enter Student ID: ");
                    int id=sc.nextInt();

                    System.out.print("Enter New Email: ");
                    String email=sc.next();

                    String query="update Student set Email=? where Stid=?";

                    PreparedStatement myStmt=con.prepareStatement(query);

                    myStmt.setString(1,email);
                    myStmt.setInt(2,id);

                    myStmt.executeUpdate();

                    System.out.println("Student Updated");
                }

                else if(choice==4)
                {
                    System.out.print("Enter Student ID: ");
                    int id=sc.nextInt();

                    String query="delete from Student where Stid=?";

                    PreparedStatement myStmt=con.prepareStatement(query);

                    myStmt.setInt(1,id);

                    myStmt.executeUpdate();

                    System.out.println("Student Deleted");
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