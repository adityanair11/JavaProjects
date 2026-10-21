
import java.net.*;
import java.io.*;

public class ChatServer
{
    public static void main(String args[])
    {
        try
        {
            ServerSocket ss=new ServerSocket(5002);
            System.out.println("Server waiting for client...");

            Socket s=ss.accept();
            System.out.println("Client connected");

            BufferedReader in=new BufferedReader(
                new InputStreamReader(s.getInputStream()));
            PrintWriter out=new PrintWriter(s.getOutputStream(),true);
            BufferedReader keyboard=new BufferedReader(
                new InputStreamReader(System.in));

            String msg,reply;

            while(true)
            {
                msg=in.readLine();

                if(msg==null || msg.equalsIgnoreCase("bye"))
                    break;

                System.out.println("Client: "+msg);

                System.out.print("Server: ");
                reply=keyboard.readLine();

                out.println(reply);

                if(reply.equalsIgnoreCase("bye"))
                    break;
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
