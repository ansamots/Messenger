package sample.classes;

public class ConnectServer {
    ConnectServer(String ip, String port, String login, String password){
        this.ip = ip;
        this.port = port;
        this.login = login;
        this.password = password;
        startLogin();
    }

    private void startLogin(){
        checkingAvailabilityServer();
        if(result){

        }else {
            
        }
    }

    private void checkingAvailabilityServer(){

    }

    public boolean results(){
        return result;
    }

    private String ip;
    private String port;
    private String login;
    private String password;
    private boolean result;
}
