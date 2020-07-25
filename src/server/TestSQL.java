package server;

import java.sql.SQLException;

public class TestSQL {
    public static void main (String[] args){
        SQLConnector sqlConnector = new SQLConnector();
        String admin = "admin1";
        String pass = "12345";
        try{
            boolean b = sqlConnector.autUser(admin, pass);
        }catch (SQLException e){
            System.out.println("Error");
            System.out.println(e);
        }

        boolean b = sqlConnector.autUser2(admin, pass);
    }
}
