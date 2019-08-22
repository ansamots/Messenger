package sample.classes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingsWindowClass {
    public void start () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/sample/fxmlFiles/SettingsWindowFXML.fxml"));
        Parent root;
        root = loader.load();
        Stage settingStage = new Stage();
        settingStage.setTitle("NeNeMa Systems");
        settingStage.setScene(new Scene(root));
        settingStage.show();
    }
}
