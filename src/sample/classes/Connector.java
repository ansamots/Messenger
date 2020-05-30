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
        if(loginPpproved){

        }
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


                }else if(loginPpproved){

                    try{
                        streamReader = new InputStreamReader(connectServer.getInputStream()); // здесь мы получаем из сокета поток байтови преобразуем в символы
                        bufferedReader = new BufferedReader(streamReader); // здесь мы уже символы преобразуем в читаемые строки данных.
                        message = bufferedReader.readLine(); // Здесь здём серввер, пока он скажет что готов принять, логин и пароль.
                        System.out.println("Чтение ридера: " + message);
                        if(message.equals("ready")){
                            writer = new PrintWriter(connectServer.getOutputStream()); // пишем наши данные в сокет. Посмотреть BufferedWriter(new OutputStreamWriter(socket));
                            writer.println(login);
                            writer.flush();
                            writer.println(password);
                            writer.flush();
                        }
                        message = bufferedReader.readLine();
                    }catch (Exception e){
                        message = "Сбой проверки" + e;
                    }


                }else if(checkAvaliable){
                    try {
                        connectServer = new Socket(ip, Integer.parseInt(port)); //создаём сокет подключения к серверу.
                        if(loginCheck){
                            message = "$L_available:true";
                            restart();
                        }else {
                            message = "available:true";
                        }
                        loginPpproved = true;
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        message = "available:false";
                        loginPpproved = false;
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
    private boolean loginCheck = false; // Булево значение, мы хотим авторизоваться итли просто проверяем доступность сервера.
    private boolean loginPpproved; // Переменная нужна для проверки, если сервер доступен, то можно запускать авторизацию.
    private boolean chat = false; // Булево значение, запущен ли уже чат или нет.

    private Socket connectServer = null;
    private PrintWriter writer = null;
    private InputStreamReader streamReader = null;
    private BufferedReader bufferedReader = null;

}
