package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;


public class SettingsWindowController {

    @FXML
    private TextField addressServerl;

    @FXML
    private TextField portServer;

    @FXML
    private CheckBox checkBoxSaveChBx;

    private boolean saveSettings;

    public void saveSettingsChBx(ActionEvent actionEvent) {
        if(checkBoxSaveChBx.isSelected() == true){
            saveSettings = true;
            System.out.println(checkBoxSaveChBx.isSelected());
        }

    }

    public void saveButton(ActionEvent actionEvent) {
    }

    public void cancelledButton(ActionEvent actionEvent) {
    }

    public void checkConnectionButton(ActionEvent actionEvent) {
    }
}
