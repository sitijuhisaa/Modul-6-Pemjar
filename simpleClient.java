import java.io.*;
import java.net.*;

public class simpleClient
{
  public final static int REMOTE_PORT = 1234;
  public final static String host = "localhost";
  public static void main(String args[])throws Exception
  {
    Socket cl = null;
    BufferedReader is = null;
    DataOutputStream os = null;
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    String userInput = null;
    String output = null;
    try
    {
        cl = new Socket(host,REMOTE_PORT);
        is = new BufferedReader(new InputStreamReader(cl.getInputStream()));
        os = new DataOutputStream(cl.getOutputStream());
    }
    catch(UnknownHostException e1)
    {
        System.out.println("Unknown Host:"+ e1);
    }
    catch(IOException e2)
    {
        System.out.println("Error io: "+ e2);
    }
    try
    {
        System.out.print("Your Univerity ?");
        userInput = stdin.readLine();
        os.writeBytes(userInput + "\n");
    }
    catch(IOException ex)
    {
        System.out.println("Error writing to server …" + ex);
    } 
    try
    {
        output = is.readLine();
        System.out.println("From server : " + output);
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }
    try
    {
        is.close();
        os.close();
        cl.close();
    }
    catch(IOException x)
    {
        System.out.println("Error writing …." + x);
    }
}
}
