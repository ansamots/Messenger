package server;

import java.io.*;
import java.net.Socket;

/**
 * В этом класссе и происходит вся логика общения с клиентом
 */
public class ServerProcessing extends Thread {
    /**
     * Конструктор получает обект сокета для дальнейшего общения с клиентом
     * @param socket - присваеваем локальной переменной переданный объект
     * @throws IOException - выбрасываем исключение которое обработается в классе вызвавшем его
     */
    public ServerProcessing (Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//        Server.story.printStory(out); // поток вывода передаётся для передачи истории последних 10
        start();
    }

    private Socket socket; // сокет, через который сервер общается с клиентом, кроме него - клиент и сервер никак не связаны
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток завписи в сокет
}
