package server;

import java.sql.*;
import java.util.ArrayList;

public class SQLConnector {
    SQLConnector(){
        try{
//            url = "jdbc:mysql://DESKTOP-N1MNM2T:3306/test_db"; // Путь к базе данных
            url = "jdbc:mysql://localhost:3306/test_db";
            login = "admin"; // Логин подключения к базе данных
            password = "Hfleuf"; // Пароль подключения к базе данных
            Class.forName("com.mysql.cj.jdbc.Driver"); // Загружаемый драйвер jdbc для MySQL
            connection = DriverManager.getConnection(url, login, password); // Делаем подключение
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            statement.executeUpdate("DROP TABLE table_user"); // Удаляем таблицу sql запросом
//            statement.executeUpdate("CREATE TABLE table_user"); // Создаём таблицу запросом
//            statement.executeUpdate("INSERT INTO table_user VALUES (NULL, 'First_User', 'test@email.ru');"); // Вставляем значение в таблицу.
        }catch(Exception e){
            System.out.println("Соединение с базой данных не удалось");
            System.out.println(e);
        }
    }


    /**
     * Метод для проверки логина и пароля на соответствие с данными в базе
     * В таблице которую используем в этом методе следующие индексы
     *  1 - Первичный ключ записи в таблице
     *  2 - Логин
     *  3 - Почта
     *  4 - Пароль
     *  5 - Дата последнего выхода из системы
     */
    public boolean autUser(String login, String password){ // В этом методе реализован запрос к базе на соответствие логина и пароля пользователя
        boolean loginResult = false;
        String query = ("SELECT * FROM table_user WHERE name = ?;"); // Сборная строка, где за место знака вопроса подставляется значение
        PreparedStatement preparedStatement = null; // При помощи этого класса будем собирать строку в запрос
        try {
            preparedStatement = connection.prepareStatement(query); // Передаём строку
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
     * метод проверяет в каких группах состоит пользователь
     * В таблице которую используем в этом методе следующие индексы
     * 1 - Внешний ключ от id пользователя
     * 2 - Внешний ключ от id группы
     * 3 - первычный ключ для таблицы с чатом
     */
    public int[] userInGroup (int userID){
        int[] a = null;
        String query = ("SELECT table_group_id FROM user_in_group WHERE table_user_id = ?;");
        try {
            preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, String.valueOf(userID));
            select = preparedStatement.executeQuery(); // выполняется запрос где в интовых значениях получаем номера групп
            select.last(); // переключаемся на последнюю строку в полученном запросе.
            int length = select.getRow(); // Получаем число последней строки
            if (length > 0){
                a = new int[length]; // создаём массив под колличество строк
                select.first(); // Возвращаем курсор на первую строчку
                int i = 0;
                a[i] = select.getInt(1); // Помещаем в массив данные из базы.
                while(select.next()){
                    i++;
                    a[i] = select.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }


    /**
     * метод для получения данных о группе кто в ней админ и кто в неё входит
     * данные полученные отправляются каждому участнику этой группы.
     * @param idGroup - получаем id руппы что бы посторить запрос для данных этой группы.
     * @return - возвращаем массив стрингов с данными о групппе
     * В таблице которую используем в этом методе следующие индексы
     * 1 - Первичный ключь id таблицы.
     * 2 - Имя группы
     * 3 - число участников (Просто интовое число, потом будут искаться участники в другой таблице, а число это нужно для отображения именно числа человек в группе)
     * 4 - Последнее сообщение адресованное этой группе
     * 5 - администратор группы, внешний ключ
     */
    public String[] infoGroup(int idGroup){
        String[] groupInfo = new String[5];
        String qwery = ("SELECT * FROM table_group WHERE id_group = ?");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(qwery);
            preparedStatement.setString(1, String.valueOf(idGroup));
            select = preparedStatement.executeQuery();
            while(select.next()){
                groupInfo[0] = select.getString(1);
                groupInfo[1] = select.getString(2);
                groupInfo[2] = select.getString(3);
                groupInfo[3] = select.getString(4);
                groupInfo[4] = select.getString(5);
            }


        }catch (SQLException e){
            System.out.println(e);
        }

        return groupInfo;
    }

    /**
     * Метод предназначен для получение данных из таблицы сообщений чата
     * проверка идёт по ключу группы и отправляется запрашиваемому
     *  В массива int[] key мы используем индексы которые потом используем
     *  для вставки в запрос и по этим ключам осуществляем поиск.
     *  В таблице которую используем в этом методе следующие индексы
     *  1 - внешний ключ, того кто отправил сообщение
     *  2 - сообщение
     *  3 - время отправления сообщения
     */
    public ArrayList<String> getChat(int[] key){
        ArrayList<String> messages = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        if(key.length > 1){ // Если длинна массива юольше чем 1 элемент то выполняется сборка строки для всавки в запрос.
            stringBuilder.append (key[0]);
            for (int i = 1; i < key.length; i++){
                stringBuilder.append(" AND ");
                stringBuilder.append (key[i]);
            }
        }else{
            stringBuilder.append (key[0]);
        }
        System.out.println("StringBuilder = "+ stringBuilder);

        String query = ("SELECT * FROM group_chat WHERE linc_id_user_in_groupcol = ?;");
        try {
            preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, String.valueOf(stringBuilder));
            ResultSet select = preparedStatement.executeQuery();
            while(select.next()){
                messages.add(select.getString(1));
                messages.add(select.getString(2));
                messages.add(select.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }


    /**
     * Метод предназначен для отправления сообщения в общую группу.
     * @param idSent Ключ отправителя сообщения
     * @param message само сообщение
     * @param timestamp Время отправки сообщения.
     */
    public void sentMessageGroup (int idSent, String message, Timestamp timestamp){
        String sentMessage = ("INSERT INTO group_chat VALUES (?, '?', ?);");
        try {
            preparedStatement = connection.prepareStatement(sentMessage);
            preparedStatement.setInt(1, idSent);
            preparedStatement.setString(2, message);
            preparedStatement.setTimestamp(3,timestamp);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Метод для получения списка чатов пользователя с пользователем
     * @param userID айдишник пользователя для получения списка чатов
     * @return Возвращаем универсальный ключ для чата пользователь с пользователем
     * В таблице которую используем в этом методе следующие индексы
     * 1 - Внешний ключ того, кто отправляет
     * 2 - Внешний ключ того, кто получает
     * 3 - одобрен ли чат с этим пользователем
     * 4 - Заблокирован ли пользователь
     * 5 - Универсальный ключ для этой связки пользователя и получателя.
     */
    public int [] userToUser (int userID){
        int[] a = null;
        String qwery = ("SELECT id_u_tu_u_key FROM user_to_user WHERE user_id_sent = ?;");
        try {
            preparedStatement = connection.prepareStatement(qwery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, String.valueOf(userID));
            select = preparedStatement.executeQuery();
            select.last();
            int length = select.getRow(); // Получаем число последней строки
            if (length > 0){
                a = new int[length];
                int i = 0;
                select.first();
                a[i] = select.getInt(1);
                while(select.next()){
                    i++;
                    a[i] = select.getInt(1);
                }
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
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet select;
}
