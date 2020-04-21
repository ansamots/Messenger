package sample.classes;

import interfaces.implementation.NotifyingImplementation;

public class WraperConnectServer extends NotifyingImplementation {

    /**
     * В конструкторе класса указываем ссылку на Медиатора и сообщае ему о своём существовании.
     */
    public WraperConnectServer() {
        super();
    }

    @Override
    public void setMessage(String message) {
        mediator.notifyUsers(this, answer);
    }

    private String answer; // Ответ от сервера
}
