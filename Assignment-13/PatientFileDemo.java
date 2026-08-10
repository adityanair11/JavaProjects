
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PatientFileDemo
{
    static File f0 = new File("patient.txt");

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

            System.out.print("Enter Patient ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Patient Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Diagnosis: ");
            String diagnosis = sc.nextLine();

            fwrite.write("Patient ID: " + id + "\n");
            fwrite.write("Name: " + name + "\n");
            fwrite.write("Age: " + age + "\n");
            fwrite.write("Diagnosis: " + diagnosis + "\n");

            fwrite.close();

            System.out.println("\nPatient details written successfully.\n");
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

            System.out.println("Reading Patient Details:\n");

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