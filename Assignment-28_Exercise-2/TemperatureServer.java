
import java.rmi.*;
import java.rmi.registry.*;

public class TemperatureServer
{
    public static void main(String args[])
    {
        try
        {
            Temperature obj=new TemperatureImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("Temperature",obj);
            System.out.println("Temperature server ready");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
