import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentResultSet
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

            Statement myStmt=con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );

            String query="select * from Student";

            ResultSet rs=myStmt.executeQuery(query);

            int choice;

            while(true)
            {
                System.out.println("\n1. Next Record");
                System.out.println("2. First Record");
                System.out.println("3. Last Record");
                System.out.println("4. Go to Record");
                System.out.println("5. Exit");

                System.out.print("Enter choice: ");
                choice=sc.nextInt();

                if(choice==1)
                {
                    if(rs.next())
                    {
                        System.out.println("Student ID : "+rs.getInt("Stid"));
                        System.out.println("Name       : "+rs.getString("Sname"));
                        System.out.println("Email      : "+rs.getString("Email"));
                    }
                    else
                    {
                        System.out.println("No more records");
                    }
                }

                else if(choice==2)
                {
                    if(rs.first())
                    {
                        System.out.println("Student ID : "+rs.getInt("Stid"));
                        System.out.println("Name       : "+rs.getString("Sname"));
                        System.out.println("Email      : "+rs.getString("Email"));
                    }
                }

                else if(choice==3)
                {
                    if(rs.last())
                    {
                        System.out.println("Student ID : "+rs.getInt("Stid"));
                        System.out.println("Name       : "+rs.getString("Sname"));
                        System.out.println("Email      : "+rs.getString("Email"));
                    }
                }

                else if(choice==4)
                {
                    System.out.print("Enter record number: ");
                    int n=sc.nextInt();

                    if(rs.absolute(n))
                    {
                        System.out.println("Student ID : "+rs.getInt("Stid"));
                        System.out.println("Name       : "+rs.getString("Sname"));
                        System.out.println("Email      : "+rs.getString("Email"));
                    }
                    else
                    {
                        System.out.println("Record not found");
                    }
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