package server;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLConnector {
    public static void main (String[] args){
        try{
            String url = "jdbc:mysql://DESKTOP-N1MNM2T:3306/sm_db_test";
            String login = "admin";
            String password = "Hfleuf";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            ResultSet select = statement.executeQuery("SELECT * FROM table_user");
            while(select.next()){
               System.out.println(select.getString(1));
                System.out.println(select.getString(2));
                System.out.println(select.getString(3));

            }
            System.out.println("All good!");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
