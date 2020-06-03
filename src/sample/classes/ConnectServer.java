package sample.classes;

import interfaces.implementation.NotifyingImplementation;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;


public class ConnectServer extends NotifyingImplementation {

    /**
     * Конструктор используется для добавления в медиатор и инсталяции паралельной задачи.
     */
    public ConnectServer(){
        super();
        connector = new Connector();
        connector.setOnSucceeded(new EventHandler<WorkerStateEvent>() { // запускаем паралельный поток в при помощи Service
            @Override
            public void handle(WorkerStateEvent event) {
                answerService((String)event.getSource().getValue());
            }
        });
    }

    /**
     * В этом методе обрабатываем ответ от сервиса, Зделано для того, чтобы обеспечить логику
     * в работе с попыткой войти в систему и проверки доступности.
     */
    private void answerService(String s){
        if(s.equals("$L_available:true")){ // Первым должы получить ответ о доступности сервера, а ключ $L_ нужен для определения что это поптка логиниться.
            availabeServer = true; // присваиваем  истину о доступнсти сервера.
            startLogin();
        }else if(s.equals("available:true")){
            addMessage("Сервер доступен");
            availabeServer = true; // присваиваем  истину о доступнсти сервера.
        }else if(s.equals("available:false")){
            addMessage("Сервер не доступен");
        } else {
            System.out.println("Ответ паралельного потока: "+ s);
        }
    }

    /**
     * Метод для авторизации в системе по указанным параметрам
     */
    private void startLogin(){
        if(!availabeServer){ // если не присвоена истина о доступнсти сервера, то проверяем сначало его доступность
            connector.loginClient(login, password); // Даём классу понять что проверяем для входв в систему
            checkingAvailabilityServer();
        }else{
            connector.restart();
        }
    }

    /**
     * Метод для проверки связи с сервером по указанным параметрам
     */
    private void checkingAvailabilityServer(){
        connector.checkAvaliable(ip, port);
        connector.restart();
    }

    /**
     * Здесь ивициализируем параметры для полного входа в систему
     */
    public void initializeParameters(String ip, String port, String login, String password){
        this.ip = ip;
        this.port = port;
        this.login = login;
        this.password = password;
    }

    /**
     * А здесь только для проверки доступности
     */
    public void initializeParameters(String ip, String port){
        this.ip = ip;
        this.port = port;
    }


    private String ip;
    private String port;

    private String login;
    private String password;

    private Connector connector = null;

    private boolean availabeServer; // булево значение о доступности сервера

    @Override
    public void setMessage(String message) {
        if(message.equals("login")){
            startLogin();
        }else if(message.equals("check")){
            checkingAvailabilityServer();
        }
    }
}
