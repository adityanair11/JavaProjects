
import java.net.*;
import java.io.*;

public class ChatClient
{
    public static void main(String args[])
    {
        try
        {
            Socket s=new Socket("localhost",5002);
            System.out.println("Connected to server");

            BufferedReader in=new BufferedReader(
                new InputStreamReader(s.getInputStream()));
            PrintWriter out=new PrintWriter(s.getOutputStream(),true);
            BufferedReader keyboard=new BufferedReader(
                new InputStreamReader(System.in));

            String msg,reply;

            while(true)
            {
                System.out.print("You: ");
                msg=keyboard.readLine();

                out.println(msg);

                if(msg.equalsIgnoreCase("bye"))
                    break;

                reply=in.readLine();

                if(reply==null)
                    break;

                System.out.println("Server: "+reply);

                if(reply.equalsIgnoreCase("bye"))
                    break;
            }

            s.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
