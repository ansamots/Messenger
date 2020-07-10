package server;


import java.sql.*;

public class SQLConnector {
//    public static void main (String[] args){
    SQLConnector(){
        try{
            url = "jdbc:mysql://DESKTOP-N1MNM2T:3306/sm_db_test"; // Путь к базе данных
            login = "admin"; // Логин подключения к базе данных
            password = "Hfleuf"; // Пароль подключения к базе данных
            Class.forName("com.mysql.cj.jdbc.Driver"); // Загружаемый драйвер jdbc для MySQL
            connection = DriverManager.getConnection(url, login, password); // Делаем подключение
            statement = connection.createStatement();
//            statement.executeUpdate("DROP TABLE table_user"); // Удаляем таблицу sql запросом
//            statement.executeUpdate("CREATE TABLE table_user"); // Создаём таблицу запросом
//            statement.executeUpdate("INSERT INTO table_user VALUES (NULL, 'First_User', 'test@email.ru');"); // Вставляем значение в таблицу.
            select = statement.executeQuery("SELECT * FROM table_user"); // Создаём запрос в базу данных
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
        String qwery = ("\"SELECT * FROM table_user WHERE mame = '"+login+"';\"");
        System.out.println(qwery);
        select = statement.executeQuery("SELECT * FROM table_user WHERE mame = 'admin';"); // Не работает
//        select = statement.executeQuery(qwery);
        while(select.next()){
            System.out.println(select.getString(1));
            System.out.println(select.getString(2));
            System.out.println(select.getString(3));
        }
        return result;
    }

    public boolean autUser2(String login, String password){
        String qwery2 = ("SELECT * FROM table_user WHERE mame = (?);"); // Сборная строка, где за место знака вопроса подставляется значение
        PreparedStatement preparedStatement = null; // При помощи этого класса будем собирать строку в запрос
        try {
            preparedStatement = connection.prepareStatement(qwery2); // Передаём строку
            preparedStatement.setString(1, login); // По индексу знака вопроса вставляем значение
            select = preparedStatement.executeQuery(); // Выполняем наш сборный запрос
            while(select.next()){ // Выводим все данные из запроса.
                System.out.println(select.getString(1));
                System.out.println(select.getString(2));
                System.out.println(select.getString(3));
            }
//            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    private String url;
    private String login;
    private String password;
    private Connection connection;
    private Statement statement;
    private ResultSet select;
}
