package interfaces.implementation;

import interfaces.Mediator;
import interfaces.Notifying;
import sample.classes.ConnectServer;
import sample.classes.SettingsWindow;
import sample.controllers.LogOnWindowController;
import sample.controllers.SettingsWindowController;

import java.util.ArrayList;

public class MediarotImplementation implements Mediator {
    private static Mediator mediator;

    private MediarotImplementation(){
    }

    /**
     * Реализуем класс Одиночку через статический метод и приватный конструктор.
     */
    public static Mediator getMediator() {
        if (mediator == null){
            mediator = new MediarotImplementation();
        }
        return mediator;
    }

    /**
     * при помощи этго метода мы сможем уведомлять те классы, которым это сообщение
     * предназначено.
     */
    public void notifyUsers(Notifying notifying, String message) {
        System.out.println("Получено сообщение: "+message + ", от: "+ notifying);

        /**
         * Определяем, если сообщение поступило от окна входа в систему, то обрабатываем его методы
         */
        if(notifying instanceof LogOnWindowController){
            if(message == "Login"){
                waitingAnswer = (LogOnWindowController)notifying; // Пометили тот объект который ждёт ответа.
                LogOnWindowController log = (LogOnWindowController) notifying;
                int length = notifyingArrayListist.size(); // Определяем длинну массива
                for (int n = 1; n <= length; n++){ // Бежим по длинне массива
                    if(notifyingArrayListist.get(n-1) instanceof ConnectServer){ // -1 ставим, потому что нумерация начинается с 0.
                        ConnectServer con = (ConnectServer) notifyingArrayListist.get(n-1);
                        con.initializeParameters(log.getHostIP(), log.getPortNumber(), log.getHostLogin(), log.getHostPassword());
                        con.setMessage("login");
                    }else if(n == length){
                        ConnectServer con = new ConnectServer();
                        con.initializeParameters(log.getHostIP(), log.getPortNumber(), log.getHostLogin(), log.getHostPassword());
                        con.setMessage("login");
                    }
                }
            }

            if(message == "Settings"){
                SettingsWindow set = new SettingsWindow();
                set.start();
            }

            if (message == "Registered"){
                System.out.println("Класс регистрации ещё не реализован");
            }
        }


        /**
         * Для отработки сообщений от этого объекта, нужен только один метод по проверке доступности сервра
         * по этому сообщение от него не проверяем.
         */
        if(notifying instanceof SettingsWindowController){
            waitingAnswer = notifying;
            if (message == "CheckAvailable"){
                SettingsWindowController set = (SettingsWindowController) notifying;
                int length = notifyingArrayListist.size();
                for (int n = 1; n <= length; n++){
                    System.out.println(n);
                    if(notifyingArrayListist.get(n-1) instanceof ConnectServer){
                        ConnectServer con = (ConnectServer) notifyingArrayListist.get(n-1);
                        con.initializeParameters(set.getIP(), set.getPort());
                        con.setMessage("check");
                    }else if(n == length){
                        ConnectServer con = new ConnectServer();
                        con.initializeParameters(set.getIP(), set.getPort());
                        con.setMessage("check");
                    }
                }
            } else if(message == "Ok"){
                for (Notifying n: notifyingArrayListist){
                    if(n instanceof LogOnWindowController){
                        n.setMessage("settingsOk");
                    }
                }
            }
        }

        /**
         * Проверяем, если ответ пришёл от класса соединения с сервером то обрабатываем его методы
         */
        if(notifying instanceof ConnectServer){
            if (waitingAnswer instanceof LogOnWindowController){
                for (Notifying n: notifyingArrayListist){
                    if(n instanceof LogOnWindowController){
                        n.setMessage(message);
                    }
                }

            }else if (waitingAnswer instanceof SettingsWindowController){
                for (Notifying n: notifyingArrayListist){
                    if(n instanceof SettingsWindowController){
                        n.setMessage(message);
                    }
                }
            }
        }


    }

    /**
     * Получаем через этот метод объекты, и добавляем в список.
     */
    public void addUsers(Notifying notifying){
        notifyingArrayListist.add(notifying);
    }

    /**
     * Метод для удаления участников
     */
    public void deleteUsers(Notifying notifying) {
        notifyingArrayListist.remove(notifying);
    }

    private Notifying waitingAnswer; // Здесь помечается объект, который ждёт ответа.

    ArrayList<Notifying> notifyingArrayListist = new ArrayList<>(); // Список участников.
}
