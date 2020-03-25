package interfaces;

public interface Mediator {
    public void notifyUsers(String message); // метод отправления сообщения всем заинтересованным участникам
    public void addUsers(Notifying notifying); // Метод добавления участников
    public void deleteUsers(Notifying notifying); // Метод для удаления участников
}
