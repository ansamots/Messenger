package sample.classes;


import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connector extends Service<String> {
    @Override
    protected Task<String> createTask() {
        return new Task<String>() {
            @Override
            protected String call() throws Exception {
                Socket connectServer = new Socket("127.0.0.1", 5000); //создаём сокет подключения к серверу.

                PrintWriter writer = new PrintWriter(connectServer.getOutputStream()); // пишем наши данные в сокет. Посмотреть BufferedWriter(new OutputStreamWriter(soccet));
                InputStreamReader streamReader = new InputStreamReader(connectServer.getInputStream()); // здесь мы получаем из сокета поток байтови преобразуем в символы
                BufferedReader bufferedReader = new BufferedReader(streamReader); // здесь мы уже символы преобразуем в читаемые строки данных.
                writer.println("Проверка соединения");
                String message = bufferedReader.readLine(); // читаем данные в готовом виде из буфера.
                try {
                    System.out.println("Concurrent thread fell asleep");
                    Thread.sleep(2000);
                    System.out.println("Concurrent thread awake");
//                    return "Паралельный поток прошёл успешно!";??
                }catch(Exception e){
                    System.out.println(e);
                }
                return message;
            }
        };
    }
    private String returneMethod(String m){
        return m;
    };
}
