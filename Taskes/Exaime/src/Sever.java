import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
    public static  double BIM ;
    public static void main(String[] args) throws Exception{
        ServerSocket s = new ServerSocket(4000);
        Socket client = s.accept();
        DataInputStream input = new DataInputStream(client.getInputStream());
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        while (true) {
            output.writeUTF("Conneting Enter the weight and height");
            int weight = input.readInt();
            int height = input.readInt();
            output.writeUTF( "InterPretation is : " + calcBIM(weight, height) + " and BMI is :");
            output.writeDouble( weight / (height * height));
        }
    }
    public static String calcBIM(int weight , int height) {
        BIM = weight / (height * height);
        if (BIM < 18.5) {
            return "Underwieght";
        } else if (18.5 <= BIM && BIM < 25.0) {
            return "Normal";
        } else if (25.0 <= BIM && BIM < 30.0) {
            return "OverWeight";
        } else if (30.0 <= BIM) {
            return "Obese";
        } else {
            return "not";
        }
    }
}
