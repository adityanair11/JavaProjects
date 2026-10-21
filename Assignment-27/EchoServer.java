
import java.net.*;
import java.io.*;

public class EchoServer
{
    public static void main(String args[])
    {
        try
        {
            ServerSocket ss=new ServerSocket(5001);
            System.out.println("Echo server started");

            Socket s=ss.accept();
            System.out.println("Client connected");

            BufferedReader in=new BufferedReader(
                new InputStreamReader(s.getInputStream()));
            PrintWriter out=new PrintWriter(s.getOutputStream(),true);

            String msg;

            while((msg=in.readLine())!=null)
            {
                if(msg.equalsIgnoreCase("bye"))
                    break;

                System.out.println("Received: "+msg);
                out.println(msg);
            }

            s.close();
            ss.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
