package server;


public class TestSQL {
    public static void main (String[] args){
        SQLConnector sqlConnector = new SQLConnector();
        String admin = "admin1";
        String pass = "123451";
        boolean b = sqlConnector.autUser(admin, pass);
        System.out.println("Ответ SQL: "+ b);

        int[] a = sqlConnector.userInGroup(1);
        System.out.println(a);
    }
}
