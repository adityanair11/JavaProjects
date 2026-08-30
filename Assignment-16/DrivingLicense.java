import java.util.*;

class InvalidAgeException extends Exception
{
    InvalidAgeException(String message)
    {
        super(message);
    }
}

public class DrivingLicense
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        try
        {
            System.out.print("Enter age: ");
            int age = sc.nextInt();

            if(age < 18)
            {
                throw new InvalidAgeException("Not eligible for driving license");
            }

            System.out.println("Eligible for driving license");
        }
        catch(InvalidAgeException e)
        {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}