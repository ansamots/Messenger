package server;


import java.util.ArrayList;

public class TestSQL {
    public static void main (String[] args){
        SQLConnector sqlConnector = new SQLConnector();
        String admin = "admin1";
        String pass = "123451";
        boolean b = sqlConnector.autUser(admin, pass);
        System.out.println("Ответ SQL: "+ b);

        int[] a = {1};

        ArrayList<String> arrayList = sqlConnector.getChat(a);
        for(String s: arrayList){
            System.out.println(s);
        }

//        sqlConnector.sentMessageGroup(1, "Сообщение из метода", D);

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
