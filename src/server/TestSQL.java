package server;


public class TestSQL {
    public static void main (String[] args){
        SQLConnector sqlConnector = new SQLConnector();
        String admin = "admin1";
        String pass = "123451";
        boolean b = sqlConnector.autUser(admin, pass);
        System.out.println("Ответ SQL: "+ b);

        int[] a = sqlConnector.userInGroup(3);
        System.out.println(a[1]);

        a = sqlConnector.userToUser(3);
        System.out.println(a[0]);

        for (int i = 0; i < 10000; i++){
            a = sqlConnector.userInGroup(3);


            a = sqlConnector.userToUser(3);

        }
    }
}
