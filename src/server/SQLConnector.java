package server;


import java.sql.*;

public class SQLConnector {
    SQLConnector(){
        try{
            url = "jdbc:mysql://DESKTOP-N1MNM2T:3306/test_db"; // Путь к базе данных
            login = "admin"; // Логин подключения к базе данных
            password = "Hfleuf"; // Пароль подключения к базе данных
            Class.forName("com.mysql.cj.jdbc.Driver"); // Загружаемый драйвер jdbc для MySQL
            connection = DriverManager.getConnection(url, login, password); // Делаем подключение
            statement = connection.createStatement();
//            statement.executeUpdate("DROP TABLE table_user"); // Удаляем таблицу sql запросом
//            statement.executeUpdate("CREATE TABLE table_user"); // Создаём таблицу запросом
//            statement.executeUpdate("INSERT INTO table_user VALUES (NULL, 'First_User', 'test@email.ru');"); // Вставляем значение в таблицу.
        }catch(Exception e){
            System.out.println("Соединение с базой данных не удалось");
            System.out.println(e);
        }
    }


    /**
     * В таблице которую используем в этом методе следующие индексы
     *  1 - Первичный ключ записи в таблице
     *  2 - Логин
     *  3 - Почта
     *  4 - Пароль
     *  5 - Дата последнего выхода из системы
     */
    public boolean autUser(String login, String password){ // В этом методе реализован запрос к базе на соответствие логина и пароля пользователя
        boolean loginResult = false;
        String qwery = ("SELECT * FROM table_user WHERE name = ?;"); // Сборная строка, где за место знака вопроса подставляется значение
        PreparedStatement preparedStatement = null; // При помощи этого класса будем собирать строку в запрос
        try {
            preparedStatement = connection.prepareStatement(qwery); // Передаём строку
            preparedStatement.setString(1, login); // По индексу знака вопроса вставляем значение
            select = preparedStatement.executeQuery(); // Выполняем наш сборный запрос
            while(select.next()){
                if (login.equals(select.getString(2))){ // Сравниваем полученый логин с логином из базы
                    if (password.equals(select.getString(4))){ // Сравниваем полученый пароль с паролем из базы
                        loginResult = true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginResult;
    }


    /**
     * метод проверяет в каких шруппах состоит пользователь
     */
    public int[] userInGroup (int userID){
        int[] a = null;
        String qwery = ("SELECT table_group_id FROM user_in_group WHERE table_user_id = ?;");
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(qwery);
            preparedStatement.setString(1, String.valueOf(userID));
            select = preparedStatement.executeQuery();
            System.out.println("Количество строк: "+select.getRow());
            while(select.next()){
                System.out.println(select.getString(1));
//                a =
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }


    private String url;
    private String login;
    private String password;
    private Connection connection;
    private Statement statement;
    private ResultSet select;
}
