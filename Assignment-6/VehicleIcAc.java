public class VehicleIcAc 
{
    class VehicleDetails
    {
        void display()
        {
            System.out.println("\nModel: Toyota Camry\nColor: Silver\nYear: 2022\nEngine: 2.5L 4-cylinder\nTransmission: Automatic\n");
        }
    }
}   
    interface Action
   {
    void start();
    void stop();
    void accelerate();
    void brake();
   }

class VehicleIcAcMain
{  
   public static void main(String args[])
   {
    VehicleIcAc obj=new VehicleIcAc();
    VehicleIcAc.VehicleDetails vehicleDetl=obj.new VehicleDetails();
    vehicleDetl.display();

    Action action=new Action()
    {
        public void start()
        {
            System.out.println("Vehicle started.");
        }
        public void stop()
        {
            System.out.println("Vehicle stopped.");
        }
        public void accelerate()
        {
            System.out.println("Vehicle accelerating.");
        }
        public void brake()
        {
            System.out.println("Vehicle braking.");
        }
    };
    action.start();
    action.accelerate();
    action.brake();
    action.stop();
   }
}




