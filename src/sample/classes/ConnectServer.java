package sample.classes;

public class ConnectServer {
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
        if(result){

        }else {
            
        }
    }

    /**
     * Метод ля проверки связи с сервером по указанным параметрам
     */
    private void checkingAvailabilityServer(){

    }

    /**
     * Метод возвращиет булево значение о доступности сервера
     * true - доступен, false -нет.
     * @return
     */
    public boolean results(){
        return result;
    }

    private String ip;
    private String port;
    private String login;
    private String password;
    private boolean result;
}
