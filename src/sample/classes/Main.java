package sample.classes;


import interfaces.implementation.Observed;

public class Main{
    public static void main(String[] args) {
        LogOnWindow logOnWindow = new LogOnWindow(); //Создаём класс для окна входа в программу
        logOnWindow.launcher(); // Метод запуска JavaFX приложения
        Observed observed = new Observed();
    }

}
