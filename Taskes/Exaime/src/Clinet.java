import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Clinet {

    public static void main(String[] args) throws Exception{
        Scanner write = new Scanner(System.in);
        Socket s = new Socket(InetAddress.getLocalHost(),4000);
        DataInputStream input = new DataInputStream(s.getInputStream());
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        while (true) {
            System.out.println(input.readUTF());
            output.writeInt(write.nextInt());
            output.writeInt(write.nextInt());
            System.out.println(input.readUTF());
            System.out.println(input.readDouble());
        }
    }
}
