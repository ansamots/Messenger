package sample.classes;

import interfaces.implementation.NotifyingImplementation;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;


public class ConnectServer extends NotifyingImplementation {

    /**
     * Конструктор используется для добавления в медиатор.
     */
    public ConnectServer(){
        super();
    }

    /**
     * Метод для авторизации в системе по указанным параметрам
     */
    public void startLogin(String ip, String port, String login, String password){
        this.ip = ip;
        this.port = port;
        this.login = login;
        this.password = password;
        checkingAvailabilityServer(ip, port);
        if(resultAvaliableServer){

        }else {
            
        }
    }

    /**
     * Метод для проверки связи с сервером по указанным параметрам
     */
    public void checkingAvailabilityServer(String ip, String port){
        conector = new Connector();
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
    Connector conector;

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
