package server;

import java.net.*;
import java.io.*;
import java.util.LinkedList;

/**
 * Класс предусмотрен как точка входа, он запускается и слушает кто подключается
 * Проверка данных и дальнейшее взаимодействие с клиентом происхлдит в других классах.
 */
public class Connector {
    public static void main(String[] args){
        System.out.println("Server started");
        ServerSocket serv; // Создаём серверный сокет с указанием порта который будет использовать программа.
        Socket socket;
        serverList = new LinkedList<>();
        dataStore = new DataStory();
        try {
            serv = new ServerSocket(8081); // сервеный порт, выставляем на каком порту будет происходить прослуша
            while(true){// помещаем в бесконечный чыкл, для прослушки портотв.
                socket = serv.accept(); // сокет нкжен для прослушки порта
                try {
                    serverList.add(new ServerProcessing(socket)); // добавляем в список новое соединение, передаём сокет для нового потока
                }catch(Exception e){
                    socket.close(); // если что-то пошло не так, закрываем сокет.
                    serv.close();
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static LinkedList<ServerProcessing> serverList; // здесь мы будем хранить все подключения к серверу клиентов.
    private static DataStory dataStore; // класс предусмотрен для
}
