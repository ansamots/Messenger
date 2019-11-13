package sample.classes;

import sample.controllers.LogOnWindowController;

public class Main{
    public static void main(String[] args) {
        LogOnWindowController logOnWindowController = new LogOnWindowController(); //Создаём класс для окна входа в программу
        logOnWindowController.launcher(); // Метод запуска JavaFX приложения
    }

}
