package sample.controllers;

import interfaces.implementation.NotifyingImplementation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.classes.SaveSettingsClient;


public class SettingsWindowController extends NotifyingImplementation {

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
            System.out.println("Настройки будут сохранены");
        }

    }

    /**
     * Метод просто скрывает окно, тем самым освобождая поток для дальнейшего отрабатывания программы.
     * @param actionEvent
     */
    public void saveButton(ActionEvent actionEvent) {
        if (checkBoxSaveChBx.isSelected()){
            SaveSettingsClient svCl = new SaveSettingsClient(addressServer.getText(), portServer.getText());

        }else{
            //можно реализовать через геттеры и сеттеры, что бы настройки не сохронялись в файле
            // но на данный момент не имеет особого смысла - программа учебная
            SaveSettingsClient svCl = new SaveSettingsClient(addressServer.getText(), portServer.getText());
        }
        Node node = (Node)actionEvent.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.hide();
        deleteMe();
    }

    /**
     *  срабатывание кнопки закрытия (просто скрываем окно)
     * @param actionEvent
     */
    public void cancelledButton(ActionEvent actionEvent) {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
        deleteMe();
    }

    /**
     *
     * @param actionEvent просто срабатывание метода на нажатие кнопки
     * Метод нужен для проверки соединения с сервером для указанного IP и порта.
     */
    public void checkConnectionButton(ActionEvent actionEvent) {
    }

    @Override
    public void setMessage(String message) {
    }
}
