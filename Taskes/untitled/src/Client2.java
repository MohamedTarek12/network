import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws Exception {
        Socket s  = new Socket(InetAddress.getLocalHost(),4000);
        DataInputStream input = new DataInputStream(s.getInputStream());
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        Scanner wirte = new Scanner(System.in);
        String send  = "";
        do {
            send = wirte.nextLine();
            output.writeUTF(send);
            System.out.println(input.readUTF());
        } while (!send.equals("Stop"));
        input.close();
        output.close();
        s.close();
    }
}
