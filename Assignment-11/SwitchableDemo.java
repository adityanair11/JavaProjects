
interface Switchable
{
    void turnOn();
}

class Light implements Switchable
{
    public void turnOn()
    {
        System.out.println("\nLight is ON");
    }
}

class Fan implements Switchable
{
    public void turnOn()
    {
        System.out.println("\nFan is ON");
    }
}

public class SwitchableDemo
{
    public static void main(String args[])
    {
        Light l = new Light();
        Fan f = new Fan();

        l.turnOn();
        f.turnOn();
    }
}