
import java.rmi.*;
import java.rmi.server.*;

public class TemperatureImpl extends UnicastRemoteObject implements Temperature
{
    TemperatureImpl() throws RemoteException
    {
        super();
    }

    public double celsiusToFahrenheit(double c) throws RemoteException
    {
        return (c*9/5)+32;
    }

    public double fahrenheitToCelsius(double f) throws RemoteException
    {
        return (f-32)*5/9;
    }
}
