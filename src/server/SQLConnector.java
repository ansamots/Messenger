package server;


import java.sql.*;

public class SQLConnector {
//    public static void main (String[] args){
    SQLConnector(){
        try{
            url = "jdbc:mysql://DESKTOP-N1MNM2T:3306/sm_db_test";
            login = "admin";
            password = "Hfleuf";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
            statement = connection.createStatement();
//            statement.executeUpdate("DROP TABLE table_user"); // Удаляем таблицу sql запросом
//            statement.executeUpdate("CREATE TABLE table_user"); // Создаём таблицу запросом
//            statement.executeUpdate("INSERT INTO table_user VALUES (NULL, 'First_User', 'test@email.ru');"); // Вставляем значение в таблицу.
            select = statement.executeQuery("SELECT * FROM table_user");
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

    public boolean autUser(String login, String password) throws SQLException {
        boolean result = false;
        select = statement.executeQuery("SELECT login FROM table_eser");
        return result;
    }
    private String url;
    private String login;
    private String password;
    private Connection connection;
    private Statement statement;
    private ResultSet select;
}
