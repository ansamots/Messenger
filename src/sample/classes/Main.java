package sample.classes;


import interfaces.implementation.MediarotImplementation;
import interfaces.implementation.NotifyingImplementation;

public class Main{
    public static void main(String[] args) {
        MediarotImplementation mediarotImplementation = new MediarotImplementation();

        LogOnWindow logOnWindow = new LogOnWindow(); //Создаём класс для окна входа в программу
        logOnWindow.launcher(); // Метод запуска JavaFX приложения
    }

}
