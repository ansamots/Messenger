package sample.classes;


import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class Conector extends Service<String> {
    @Override
    protected Task<String> createTask() {
        return new Task<String>() {
            @Override
            protected String call() throws Exception {
                try {
                    System.out.println("Concurrent thread fell asleep");
                    Thread.sleep(2000);
                    System.out.println("Concurrent thread awake");
//                    return "Паралельный поток прошёл успешно!";??
                }catch(Exception e){
                    System.out.println(e);
                }
                return "Паралельный поток прошёл успешно!";
            }
        };
    }
}
