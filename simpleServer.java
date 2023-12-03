import java.io.*;
import java.net.*;

public class simpleServer
{
    public final static int TESTPORT = 1234;
    public static void main (String args[])
    {
        ServerSocket checkServer = null;
        String line;
        BufferedReader is = null;
        DataOutputStream os = null;
        Socket clientSocket = null;

        try
        {
            checkServer = new ServerSocket(TESTPORT);
            System.out.println("Server Ready …");
        }
        catch(IOException e)
        {
        System.out.println(e);
        }
        try
        {
            clientSocket = checkServer.accept();
            is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            os = new DataOutputStream(clientSocket.getOutputStream());
        }
        catch(Exception ei)
        {
            ei.printStackTrace();
        }
         try
        {
            line = is.readLine();
            System.out.println("From Client :"+line);
            os.writeBytes(line);
            if(line.compareTo("unisbank")==0)
        {
            os.writeBytes("Welcome To Unisbank.");
        }
        else
        {
            os.writeBytes("Sorry,this is private area.");
        }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        try
        {
            os.close();
            is.close();
            clientSocket.close();
        }
        catch(IOException ie)
        {
            ie.printStackTrace();
        }
   }
}

