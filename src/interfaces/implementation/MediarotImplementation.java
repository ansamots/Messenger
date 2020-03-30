package interfaces.implementation;

import interfaces.Mediator;
import interfaces.Notifying;

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
    public void notifyUsers(String message) {
        System.out.println("Получено сообщение: "+message);
        for (int a = 0; a < notifyingArrayListist.size(); a++){
            System.out.println(notifyingArrayListist.get(a));
            Notifying n = notifyingArrayListist.get(a);
            n.setMessage(message);
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

    ArrayList<Notifying> notifyingArrayListist = new ArrayList<>(); // Список участников.
}
