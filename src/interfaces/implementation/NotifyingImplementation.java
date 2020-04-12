package interfaces.implementation;

import interfaces.Mediator;
import interfaces.Notifying;

public abstract class NotifyingImplementation implements Notifying {
    public Mediator mediator;
    /**
     * В конструкторе класса указываем ссылку на Медиатора и сообщае ему о своём существовании.
     * @param mediator
     */
    public NotifyingImplementation(Mediator mediator){
        this.mediator = mediator;
        mediator.addUsers(this);
    }

    /**
     * Метод для отправления уведомлений медиатору.
     */
    public void addMessage(String message) {
        mediator.notifyUsers(message);
    }

}
