package Lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws InterruptedException {


        try (ServerSocket server = new ServerSocket(8189);
            BufferedReader brs = new BufferedReader(new InputStreamReader(System.in));) {

                System.out.println("Сервер запущен, ожидает подключения клиента");
                Socket client = server.accept();
                System.out.println("Клиент подключился");
                DataInputStream inServer = new DataInputStream(client.getInputStream());
                System.out.println("inServer good");
                DataOutputStream outServer = new DataOutputStream(client.getOutputStream());
                System.out.println("outServer good");
                while (true){
                    String str = inServer.readUTF();
                    System.out.println("from client Msg:" + str);
                    if (brs.ready()){
                        String serverMsg = brs.readLine();
                        System.out.println("Сообщение сервера записано и отправлено");
                        outServer.writeUTF(serverMsg);

                    }

                }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
