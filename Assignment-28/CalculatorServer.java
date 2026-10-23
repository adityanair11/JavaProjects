
import java.rmi.*;
import java.rmi.registry.*;

public class CalculatorServer
{
    public static void main(String args[])
    {
        try
        {
            CalculatorImpl obj=new CalculatorImpl();

            LocateRegistry.createRegistry(1099);

            Naming.rebind("rmi://localhost:1099/Calculator",obj);

            System.out.println("Calculator server ready");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
