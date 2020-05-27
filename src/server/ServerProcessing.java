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
//        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//        autentificatedUser = false;
//        Server.story.printStory(out); // поток вывода передаётся для передачи истории последних 10
        start();
    }

    public void run(){
//        this.socket = socket;

        autentificatedUser = false;
        try {

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (!autentificatedUser) { // здесь сделали разделение по авторизации и уже авторизованному пользователю
                System.out.println("Метка");
                login = in.readLine();
                password = in.readLine();
                checkAuthentication(login, password);

            }
            while (true){ // Здесь пользователь уже авторизован.
                inMessage = in.readLine();
                System.out.println("Чтение строки: "+ inMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * В этом методе разделяются сообщения по принципу, ключей, дабы определить это простое сообщение
     * или логин и пароль.
     */
    private void checkAuthentication(String l, String p) {
        try{
            if(l.equals("Admin") && p.equals("12345")){
                autentificatedUser = true;
                out.write("Проверка пройдена");
                out.flush();
                System.out.println("Проверка пройена");
            }else {
                out.write("Проверка не пройдена");
                out.flush();
                System.out.println("Проверка не пройена");
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    private Socket socket; // сокет, через который сервер общается с клиентом, кроме него - клиент и сервер никак не связаны
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток записи в сокет

    private boolean autentificatedUser;
    private String outMessage; // Переменная для отправки сообщений
    private String inMessage; // Переменная для приёма сообщений через сокет
    private String login;
    private String password;
}
