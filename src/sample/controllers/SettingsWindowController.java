package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class SettingsWindowController {

    @FXML
    private TextField addressServer;

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
//            ((Node)actionEvent.getSource()).getScene().getWindow().hide();
            System.out.println("Настройки будут сохранены");
        }

    }

    public void saveButton(ActionEvent actionEvent) {
        Node node = (Node)actionEvent.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.hide();
    }

    public void cancelledButton(ActionEvent actionEvent) {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
    }

    /**
     *
     * @param actionEvent просто срабатывание метода на нажатие кнопки
     * Метод нужен для проверки соединения с сервером для указанного IP и порта.
     */
    public void checkConnectionButton(ActionEvent actionEvent) {
    }
}
