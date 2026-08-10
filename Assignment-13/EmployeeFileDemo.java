
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeFileDemo
{
    static File f0 = new File("employee.txt");

    public static void main(String args[])
    {
        filewriter();
        filereader();
    }

    static void filewriter()
    {
        Scanner sc = new Scanner(System.in);

        try
        {
            FileWriter fwrite = new FileWriter(f0);

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            fwrite.write("Employee ID: " + id + "\n");
            fwrite.write("Name: " + name + "\n");
            fwrite.write("Department: " + dept + "\n");
            fwrite.write("Salary: " + salary + "\n");

            fwrite.close();

            System.out.println("\nEmployee details written successfully.\n");
        }
        catch(IOException e)
        {
            System.out.println("Unexpected error occurred!");
            e.printStackTrace();
        }
    }

    static void filereader()
    {
        try
        {
            Scanner dataReader = new Scanner(f0);

            System.out.println("Reading Employee Details:\n");

            while(dataReader.hasNextLine())
            {
                String fileData = dataReader.nextLine();
                System.out.println(fileData);
            }

            dataReader.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Unexpected error occurred!");
            e.printStackTrace();
        }
    }
}