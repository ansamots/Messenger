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
            Stage settingStage = new Stage();
            settingStage.setTitle("NeNeMa Systems");
            settingStage.setScene(new Scene(root));
//            settingStage.initModality(Modality.WINDOW_MODAL);
//            settingStage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            System.out.println("Окно настроек открыто");
            settingStage.showAndWait();
            System.out.println("Окно настроек закрыто)");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getParametorIP(){
        return ip;
    }

    public String getParametorPort(){
        return port;
    }

    /**
     * стандартный метод для запуска JavaFX приложения
     */
//    public void launcher(){ // стандартный метод для запуска JavaFX приложения
//        launch();
//    }

    private Stage stage;
    private String ip;
    private String port;
}
