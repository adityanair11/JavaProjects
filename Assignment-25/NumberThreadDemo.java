
class NumberThread extends Thread
{
    String name;

    NumberThread(String name)
    {
        this.name=name;
    }

    public void run()
    {
        for(int i=1;i<=5;i++)
        {
            System.out.println(name+": "+i);

            try
            {
                Thread.sleep(500);
            }
            catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }
    }
}

public class NumberThreadDemo
{
    public static void main(String args[])
    {
        NumberThread t1=new NumberThread("Thread 1");
        NumberThread t2=new NumberThread("Thread 2");

        System.out.println("Thread 1 state: "+t1.getState());

        t1.start();
        t2.start();

        try
        {
            t1.join();
            t2.join();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }

        System.out.println("Thread 1 state: "+t1.getState());
        System.out.println("Both threads completed");
    }
}
