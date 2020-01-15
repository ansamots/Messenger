package sample.classes;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.controllers.SettingsWindowController;

import java.io.IOException;

public class SettingsWindow {
    public void start(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/sample/fxmlFiles/SettingsWindowFXML.fxml"));
            Parent root;
            root = loader.load();
            stageSettings = new Stage();
            stageSettings.setTitle("NeNeMa Systems");
            stageSettings.setScene(new Scene(root));
            System.out.println("Окно настроек открыто");
            settingWindowController = loader.getController(); // Получаем ссылку на контроллер, для обращения к его переменным.
            stageSettings.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    System.out.println("Закрытие окна настроек - отработано не в контроллере");
                    exitProgram = true;
                }
            });
            stageSettings.showAndWait();
            System.out.println("Окно настроек закрыто)");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * нетод возваращает булево значение, была ли закрыта программа или нет.
     * @return
     */
    public boolean isExitProgram() {
        return exitProgram;
    }

    /**
     * Получаем значение IP из контолелра прям в методе, что бы не хранить лишних переменных.
     * Далее возвращаем запросимшему классу значение, Класс служит своего рода прослойкой.
     * @return
     */
    public String getParametorIP(){
        String ip = settingWindowController.getAddressServer();
        return ip;
    }

    /**
     * Получаем значение парта из контолелра прям в методе, что бы не хранить лишних переменных.
     * Далее возвращаем запросимшему классу значение, Класс служит своего рода прослойкой.
     * @return
     */
    public String getParametorPort(){
        String port = settingWindowController.getPortServer();
        return port;
    }

    /**
     * Получаем значение из контроллера и передаём знчение запросившему классу
     * Снова класс служит своего рода прослойкой.
     * @return
     */
    public boolean getSaveSettings(){
        return settingWindowController.getSaveSettings();
    }

    /**
     * стандартный метод для запуска JavaFX приложения. Не запускается т.к. работает в одном потоке всё приложение(((
     */
//    public void launcher(){ // стандартный метод для запуска JavaFX приложения
//        launch();
//    }

    private boolean exitProgram;
    SettingsWindowController settingWindowController;
    private Stage stageSettings;
}
