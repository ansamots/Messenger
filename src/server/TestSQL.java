package server;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

public class TestSQL {
    public static void main (String[] args){
        SQLConnector sqlConnector = new SQLConnector();
        String admin = "admin1";
        String pass = "123451";
        boolean b = sqlConnector.autUser(admin, pass);
        System.out.println("Ответ SQL: "+ b);

        int[] a = {1, 2};

//        ArrayList<String> arrayList = sqlConnector.getChatAll(a);
//        for(String s: arrayList){
//            System.out.println(s);
//        }

//        Timestamp timestamp = new Timestamp();

        ArrayList<String> s = sqlConnector.getMessageGroup(1, a, Timestamp.valueOf("1970-01-01 12:00:00"));
        for(String s1: s){
            System.out.println(s1);
        }

//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        sqlConnector.sentMessageGroup(1, 1, "Сообщение из метода", timestamp);

//        int[] a = sqlConnector.userInGroup(3);
//        System.out.println("Вывод 1");
//        System.out.println(a[1]);
//
//        a = sqlConnector.userToUser(3);
//        System.out.println("Вывод 2");
//        System.out.println(a[0]);
//
//        String[] s = sqlConnector.infoGroup(2);
//        System.out.println("Вывод 3");
//        for (String q: s) {
//            System.out.println(q);
//        }

//        for (int i = 0; i < 10000; i++){
//            a = sqlConnector.userInGroup(3);
//
//
//            a = sqlConnector.userToUser(3);
//
//        }
    }
}
