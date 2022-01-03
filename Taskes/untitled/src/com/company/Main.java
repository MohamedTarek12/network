package com.company;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
public class Main {
    static ServerSocket Serversocket ;
    static Socket Server ;
    public static void main(String[] args) throws Exception  {
        Serversocket = new ServerSocket(4000);
        do {
            Server = Serversocket.accept();
            ClientHendler t1 = new ClientHendler(Server);
            t1.start();
        } while (true);
    }

}
class ClientHendler extends Thread {
    Socket s ;
    DataInputStream input ;
    DataOutputStream output ;
    ClientHendler(Socket s) throws  Exception{
        try {
            this.s = s ;
            input = new DataInputStream(s.getInputStream());
            output = new DataOutputStream(s.getOutputStream());
        } catch (Exception e) {}
    }
    @Override
    public void run ()  {
        String recived = "" ;
        System.out.println("1");
        while (!recived.equals("Stop")) {
            try {
                recived = input.readUTF();
                System.out.println(recived);
                output.writeUTF("ECHO " + recived);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        try {
            if (!input.equals(null))
                input.close();
        } catch (Exception e) {}
        try {
            if (!output.equals(null))
                output.close();
        } catch (Exception e) {}
        try {
            if (!s.equals(null))
                s.close();
        } catch (Exception e) {}
    }
}
