package sample.classes;


import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connector extends Service<String> {

    /**
     * ПРоверка на доступность сервера.
     */
    public void checkAvaliable(String ip, String port){
        this.ip = ip;
        this.port = port;
        checkAvaliable = true;
    }

    /**
     * Проверка логина и пароля для учётной записи в системе.
     */
    public void loginClient(String login, String password){
        this.login = login;
        this.password = password;
        loginCheck = true;
    }

    @Override
    protected Task<String> createTask() {
        return new Task<String>() {
            @Override
            protected String call() throws Exception {
                String message = null;
                if(chat){
                    try {
                        message = bufferedReader.readLine(); // читаем данные в готовом виде из буфера.
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    return message;


                }else if(loginCheck){

                    try{
                        writer = new PrintWriter(connectServer.getOutputStream()); // пишем наши данные в сокет. Посмотреть BufferedWriter(new OutputStreamWriter(socket));
                        writer.println(login);
                        writer.flush();
                        writer.println(password);
                        writer.flush();

                        streamReader = new InputStreamReader(connectServer.getInputStream()); // здесь мы получаем из сокета поток байтови преобразуем в символы
                        bufferedReader = new BufferedReader(streamReader); // здесь мы уже символы преобразуем в читаемые строки данных.
                        message = bufferedReader.readLine();
                    }catch (Exception e){
                        message = "Сбой проверки";
                    }


                }else if(checkAvaliable){
                    try {
                        connectServer = new Socket("127.0.0.1", 5000); //создаём сокет подключения к серверу.
                        message = "true";
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        message = "false";
                    }
                }

                return message; // передалать
            }
        };
    }

    private String ip;
    private String port;
    private String login;
    private String password;

    private boolean checkAvaliable = false; // Булево значение для определяет, доступен сервер или нет.
    private boolean loginCheck = false; // Булево значение, пройдена авторизация или нет.
    private boolean chat = false; // Булево значение, запущен ли уже чат или нет.

    private Socket connectServer = null;
    private PrintWriter writer = null;
    private InputStreamReader streamReader = null;
    private BufferedReader bufferedReader = null;

}
