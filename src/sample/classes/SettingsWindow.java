package sample.classes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingsWindow {
    public void start(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/sample/fxmlFiles/SettingsWindowFXML.fxml"));
            Parent root;
            root = loader.load();
            Stage stageSettings = new Stage();
            stageSettings.setTitle("NeNeMa Systems");
            stageSettings.setScene(new Scene(root));
//            settingWindowController = loader.getController(); // Получаем ссылку на контроллер, для обращения к его переменным.
//            stageSettings.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
//                @Override
//                public void handle(WindowEvent event) {
//                    exitProgram = true;
//                }
//            });
            stageSettings.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
