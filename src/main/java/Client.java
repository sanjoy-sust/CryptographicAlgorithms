import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        DataOutputStream oos = null;
        DataInputStream ois = null;
        for(int i=0; i<5;i++){
            //establish socket connection to server
            socket = new Socket(host.getHostName(), 9876);
            //write to socket using ObjectOutputStream
            oos = new DataOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");
            if(i==4)
                oos.writeBytes("exit");
            else
                oos.writeBytes(""+i);
            //read the server response message
            ois = new DataInputStream(socket.getInputStream());
            String message = String.valueOf(ois.read());
            System.out.println("Message: " + message);
            //close resources
            ois.close();
            oos.close();
            Thread.sleep(100);
        }
    }
}
