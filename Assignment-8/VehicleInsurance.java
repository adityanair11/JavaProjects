
class Vehicle
{
    String vehicleNo;
    String owner;

    Vehicle(String vehicleNo, String owner)
    {
        this.vehicleNo = vehicleNo;
        this.owner = owner;
    }

    void display()
    {
        System.out.println("\nVehicle Number : " + vehicleNo);
        System.out.println("Owner : " + owner);
    }
}

class Insurance extends Vehicle
{
    double premium;

    Insurance(String vehicleNo, String owner, double premium)
    {
        super(vehicleNo, owner);
        this.premium = premium;
    }

    void display()
    {
        super.display();
        System.out.println("Premium : "+premium);
    }
}

public class VehicleInsurance
{
    public static void main(String args[])
    {
        Insurance obj= new Insurance("MH12JC8549", "Aditya Nair", 15000);

        obj.display();
    }
}