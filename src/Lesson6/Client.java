package Lesson6;


import java.io.*;
import java.net.Socket;
import java.io.BufferedReader;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8189;


    public static void main(String[] args) throws InterruptedException{
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ) {

            while (true) {
                    String serverMsg = in.readUTF();
                    System.out.println("Сервер:" + serverMsg);
                        String clientMsg = br.readLine();
                        System.out.println("Сообщение клиента записано и отправлено на сервер");
                        out.writeUTF(clientMsg);


            }


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
