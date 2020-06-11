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
            out = new PrintWriter(socket.getOutputStream(), true);
//            out.println("ready");
//            System.out.println(socket);
            while (!autentificatedUser) { // здесь сделали разделение по авторизации и уже авторизованному пользователю

                System.out.println("Метка -1");
                login = in.readLine();
                System.out.println(login);
                System.out.println("Метка -2");
                password = in.readLine();
                System.out.println(password);
                System.out.println("Метка -3");
                System.out.println("Login: "+login+" Password: "+password);
                checkAuthentication(login, password);
                System.out.println("Метка -4");

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
                out.println("Проверка пройдена");
                System.out.println("Проверка пройена");
            }else {
                out.println("Проверка не пройдена");
                System.out.println("Проверка не пройена");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private Socket socket; // сокет, через который сервер общается с клиентом, кроме него - клиент и сервер никак не связаны
    private BufferedReader in; // поток чтения из сокета
    private PrintWriter out; // поток записи в сокет

    private boolean autentificatedUser;
    private String outMessage; // Переменная для отправки сообщений
    private String inMessage; // Переменная для приёма сообщений через сокет
    private String login;
    private String password;
}
