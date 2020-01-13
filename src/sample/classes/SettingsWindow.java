package sample.classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.controllers.LogOnWindowController;
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
//            settingStage.initModality(Modality.WINDOW_MODAL);
//            settingStage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            System.out.println("Окно настроек открыто");
            settingWindowController = loader.getController(); // Получаем ссылку на контроллер, для обращения к его переменным.
            stageSettings.showAndWait();
            System.out.println("Окно настроек закрыто)");
//            stageSettings.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

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
     * стандартный метод для запуска JavaFX приложения
     */
//    public void launcher(){ // стандартный метод для запуска JavaFX приложения
//        launch();
//    }

    SettingsWindowController settingWindowController;
    private Stage stageSettings;
}
