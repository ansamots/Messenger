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
        connector = new Connector();
    }

    /**
     * Метод для авторизации в системе по указанным параметрам
     */
    public void startLogin(String ip, String port, String login, String password){
        this.ip = ip;
        this.port = port;
        this.login = login;
        this.password = password;
        if(resultAvaliableServer){
            System.out.println("Страрт-логин истина");
            checkingAvailabilityServer(ip, port);
        }else {
            System.out.println("Страрт-логин лож");
            checkingAvailabilityServer(ip, port);
        }
    }

    /**
     * Метод для проверки связи с сервером по указанным параметрам
     */
    public void checkingAvailabilityServer(String ip, String port){
        connector.checkAvaliable(ip, port);
        connector.setOnSucceeded(new EventHandler<WorkerStateEvent>() { // запускаем паралельный поток в при помощи Service
            @Override
            public void handle(WorkerStateEvent event) {
                System.out.println("Ответ паралельного потока: "+ event.getSource().getValue());
                addMessage((String)event.getSource().getValue());
//                connector.restart();
                if((String)event.getSource().getValue() == "true"){
                    resultAvaliableServer = true;
                }else if((String)event.getSource().getValue() == "false"){
                    resultAvaliableServer = false;
                }
            }
        });
        if(startingCheck){
            connector.restart();
        }else{
            connector.start();
            startingCheck = true;
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

    private boolean startingCheck = false; // Переменная нужна для контроля разового старта коннектора.

    private String ip;
    private String port;

    private String login;
    private String password;
    private boolean resultAvaliableServer = false;
    Connector connector = null;

    @Override
    public void setMessage(String message) {

    }
}
