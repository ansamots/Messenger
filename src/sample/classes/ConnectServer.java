package sample.classes;

import interfaces.implementation.NotifyingImplementation;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;


public class ConnectServer extends NotifyingImplementation {


    /**
     *
     * Конструктор для проверки проверки доступности сервера
     * @param ip
     * @param port
     */
    public ConnectServer(String ip, String port){
        super();
        this.ip = ip;
        this.port = port;
    }

    /**
     * Конструктор используется для авторизации в системе.
     * @param ip
     * @param port
     * @param login
     * @param password
     */
    public ConnectServer(String ip, String port, String login, String password){
        super();
        this.ip = ip;
        this.port = port;
        this.login = login;
        this.password = password;
    }

    /**
     * Метод для авторизации в системе по указанным параметрам
     */
    public void startLogin(){
        checkingAvailabilityServer();
        if(resultAvaliableServer){

        }else {
            
        }
    }

    /**
     * Метод для проверки связи с сервером по указанным параметрам
     */
    public void checkingAvailabilityServer(){
        conector = new Conector();
        conector.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                System.out.println("Ответ паралельного потока: "+ event.getSource().getValue());
                addMessage("true");
            }
        });
        conector.start();
        if (true){
            resultAvaliableServer = true;
        }else {
            resultAvaliableServer = false;
        }
    }

    /**
     * Метод возвращиет булево значение о доступности сервера
     * true - доступен, false -нет.
     * @return
     */
    public boolean results(){
        return resultAvaliableServer;
    }




    private void testPrint(){
        System.out.println(ip);
        System.out.println(port);
        System.out.println(login);
        System.out.println(password);
//        mediator.notifyUsers(this,"false");
    }


    private String ip;
    private String port;

    private String login;
    private String password;
    private boolean resultAvaliableServer;
    Conector conector;

    @Override
    public void setMessage(String message) {

    }

//    @Override
//    public void addMessage(String message) {
//
//    }
//
//    @Override
//    public void setMessage(String message) {
//
//    }
//
//    @Override
//    public void deleteMe() {
//
//
//    }
//    public Mediator mediator;
}
