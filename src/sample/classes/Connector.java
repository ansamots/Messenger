package sample.classes;


import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connector extends Service<String> {
    public Connector() {
//        try{
//            connectServer = new Socket("127.0.0.1", 5000); //создаём сокет подключения к серверу.
//            writer = new PrintWriter(connectServer.getOutputStream()); // пишем наши данные в сокет. Посмотреть BufferedWriter(new OutputStreamWriter(socket));
//            streamReader = new InputStreamReader(connectServer.getInputStream()); // здесь мы получаем из сокета поток байтови преобразуем в символы
//            bufferedReader = new BufferedReader(streamReader); // здесь мы уже символы преобразуем в читаемые строки данных.
//        }catch (Exception e){
//            System.out.println(e);
//        }

    }

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
                        streamReader = new InputStreamReader(connectServer.getInputStream()); // здесь мы получаем из сокета поток байтови преобразуем в символы
                        bufferedReader = new BufferedReader(streamReader); // здесь мы уже символы преобразуем в читаемые строки данных.
                    }catch (Exception e){

                    }
                }else if(checkAvaliable){
                    try {
                        connectServer = new Socket("127.0.0.1", 5000); //создаём сокет подключения к серверу.
                        System.out.println("Сервер доступен");
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

    private boolean checkAvaliable = false;
    private boolean loginCheck = false;
    private boolean chat = false;
    Socket connectServer = null;
    PrintWriter writer = null;
    InputStreamReader streamReader = null;
    BufferedReader bufferedReader = null;

}
