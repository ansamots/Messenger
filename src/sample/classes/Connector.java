package sample.classes;


import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.BufferedReader;
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
        checkAvailable = true;
    }

    /**
     * Проверка логина и пароля для учётной записи в системе.
     */
    public void loginClient(String login, String password){
        if(loginApproved){

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


                }else if(loginApproved){

                    try{
                        streamReader = new InputStreamReader(connectServer.getInputStream()); // здесь мы получаем из сокета поток байтови преобразуем в символы
                        bufferedReader = new BufferedReader(streamReader); // здесь мы уже символы преобразуем в читаемые строки данных.
                        message = bufferedReader.readLine(); // Здесь ждём серввер, пока он скажет что готов принять, логин и пароль.
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


                }else if(checkAvailable){
                    try {
                        connectServer = new Socket(ip, Integer.parseInt(port)); //создаём сокет подключения к серверу.
                        if(loginCheck){
                            message = "$L_available:true"; // здесь отправляем доступность сервера для дальней проверки логина и пароля
//                            restart();
                        }else {
                            message = "available:true"; // здесь отправляем обычную доступность сервера
                        }
                        loginApproved = true; // присваиваем истину для того, что бы можно было запускать проверку логина  пароля.
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        message = "available:false";
                        loginApproved = false; // Присваиваем лож, значит проверку логина и пароля нельзя запускать
                    }
                }

                System.out.println(message);
                return message; // передалать
            }
        };
    }

    private String ip;
    private String port;
    private String login;
    private String password;

    private boolean checkAvailable = false; // Булево значение для определяет, доступен сервер или нет.
    private boolean loginCheck = false; // Булево значение, мы хотим авторизоваться итли просто проверяем доступность сервера.
    private boolean loginApproved; // Переменная нужна для проверки, если сервер доступен, то можно запускать авторизацию.
    private boolean chat = false; // Булево значение, запущен ли уже чат или нет.

    private Socket connectServer = null;
    private PrintWriter writer = null;
    private InputStreamReader streamReader = null;
    private BufferedReader bufferedReader = null;

}
