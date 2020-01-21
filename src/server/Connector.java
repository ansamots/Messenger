package server;

import java.net.*;
import java.io.*;

public class Connector {
    public static void main(String[] args){
        System.out.println("Server started");
        ServerSocket serv; // Создаём серверный сокет с указанием порта который будет использовать программа.
        Socket socket;
        try {
            serv = new ServerSocket(8081);
            socket = serv.accept();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter writer = new BufferedWriter(outputStreamWriter);
            writer.write("Test");
            writer.newLine();
            writer.flush();

            writer.close();
            outputStreamWriter.close();
            serv.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        System.out.println("Подключено!");

    }
}
