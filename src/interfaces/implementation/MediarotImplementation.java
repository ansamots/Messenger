package interfaces.implementation;

import interfaces.Mediator;
import interfaces.Notifying;
import sample.classes.ConnectServer;
import sample.controllers.LogOnWindowController;

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
        System.out.println("Получено сообщение: "+message);
        if(notifying instanceof LogOnWindowController){
            if(message == "Login"){
                LogOnWindowController log = (LogOnWindowController) notifying;
                ConnectServer con = new ConnectServer(log.getHostIP(), log.getPortNumber(), log.getHostLogin(), log.getHostPassword());
                Thread conThread = new Thread(con);
                conThread.start();
            }
        }

//        for (int a = 0; a < notifyingArrayListist.size(); a++){
//            System.out.println(notifyingArrayListist.get(a));
//            Notifying n = notifyingArrayListist.get(a);
//            n.setMessage(message);
//        }
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

    ArrayList<Notifying> notifyingArrayListist = new ArrayList<>(); // Список участников.
}
