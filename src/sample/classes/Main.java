package sample.classes;

public class Main{
    public static void main(String[] args) {
        LogOnWindowClass logOnWindowClass = new LogOnWindowClass(); //Создаём класс для окна входа в программу
        try{
            logOnWindowClass.launcher();
        }catch (Exception e){ // Ловим любые выды исключений, потом дописать исключение на прохождения авторизации
            System.out.println(e);
        }

    }

}
