package server;


import com.mysql.cj.xdevapi.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class SQLConnector {
    public static void main (String[] args){
        try{
            String url = "jdbc:mysql://DESKTOP-N1MNM2T:3306/sm_db_test";
            String login = "admin";
            String password = "Hfleuf";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = (Statement) connection.createStatement();
//            ResultSet select = statement
            System.out.println("All good!");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
