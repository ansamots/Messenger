package interfaces;

public interface LogOnInterface {

    /**
     * интерфейс для взаимодействия класса LogOnWindowController c LogOnWindow
     */
    public void settingsOpen(); // Метод запускается при нажатии кнопки настроек

    public  void logOn(); // метод запускается при нажатии кнопки входа в систему

    public void registered(); // метод запускает страничку регистрации
}
