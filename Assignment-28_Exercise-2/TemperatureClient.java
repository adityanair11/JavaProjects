
import java.rmi.*;
import java.util.*;

public class TemperatureClient
{
    public static void main(String args[])
    {
        try
        {
            Temperature obj=(Temperature)Naming.lookup("rmi://localhost/Temperature");
            Scanner sc=new Scanner(System.in);

            System.out.print("Enter temperature in Celsius: ");
            double c=sc.nextDouble();
            System.out.println("Fahrenheit: "+obj.celsiusToFahrenheit(c));

            System.out.print("Enter temperature in Fahrenheit: ");
            double f=sc.nextDouble();
            System.out.println("Celsius: "+obj.fahrenheitToCelsius(f));

            sc.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
