import java.util.*;
public class VehicleIcAc 
{
    class Inner
    {
        void display()
        {
            System.out.println("Model: Toyota Camry\nColor: Silver\nYear: 2022\nEngine: 2.5L 4-cylinder\nTransmission);");
        }
    }
    
    interface Action
   {
    void start();
    void stop();
    void accelerate();
    void brake();
   }

   public static void main(String args[])
   {
    VehicleIcAc obj=new VehicleIcAc();
    Inner innerObj=obj.new Inner();
    innerObj.display();

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




