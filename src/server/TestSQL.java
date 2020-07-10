package server;

import java.sql.SQLException;

public class TestSQL {
    public static void main (String[] args){
        SQLConnector sqlConnector = new SQLConnector();
        String admin = "admin";
        String pass = "12345";
        boolean b = sqlConnector.autUser2(admin, pass);
    }
}
