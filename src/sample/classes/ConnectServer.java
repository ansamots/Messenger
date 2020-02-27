package sample.classes;

public class ConnectServer extends Thread{
    /**
     * Контроллер для проверки проверки доступности сервера
     * @param ip
     * @param port
     */
    ConnectServer(String ip, String port){
        this.ip = ip;
        this.port = port;
        checkingAvailabilityServer();
    }

    /**
     * Контроллер используется для авторизации в системе.
     * @param ip
     * @param port
     * @param login
     * @param password
     */
    ConnectServer(String ip, String port, String login, String password){
        this.ip = ip;
        this.port = port;
        this.login = login;
        this.password = password;
        startLogin();
    }

    /**
     * Метод для авторизации в системе по указанным параметрам
     */
    private void startLogin(){
        checkingAvailabilityServer();
        if(resultAvaliableServer){

        }else {
            
        }
    }

    /**
     * Метод для проверки связи с сервером по указанным параметрам
     */
    private boolean checkingAvailabilityServer(){
        if (true){
            return true;
        }else {
            return false;
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

    @Override
    public void run() {
        super.run();
        System.out.println("Паралельный поток");
    }

    private String ip;
    private String port;

    private String login;
    private String password;
    private boolean resultAvaliableServer;
}
