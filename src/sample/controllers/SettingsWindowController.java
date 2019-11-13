package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.classes.Main;

import java.io.IOException;


public class SettingsWindowController {
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

    @FXML
    private TextField addressServerl;

    @FXML
    private TextField portServer;

    @FXML
    private CheckBox checkBoxSaveChBx;

    private boolean saveSettings;

    /**
     * метод для определения, хочет ли пользователь сохранить настройки сервера или нет
     */
    public void saveSettingsChBx(ActionEvent actionEvent) {
        if(checkBoxSaveChBx.isSelected() == true){
            saveSettings = true;
            System.out.println(checkBoxSaveChBx.isSelected());
            ((Node)actionEvent.getSource()).getScene().getWindow().hide();
        }

    }

    public void saveButton(ActionEvent actionEvent) {
    }

    public void cancelledButton(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent просто срабатывание метода на нажатие кнопки
     * Метод нужен для проверки соединения с сервером для указанного IP и порта.
     */
    public void checkConnectionButton(ActionEvent actionEvent) {
    }
}
