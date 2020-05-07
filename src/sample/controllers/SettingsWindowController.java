package sample.controllers;

import interfaces.implementation.NotifyingImplementation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


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
//            ((Node)actionEvent.getSource()).getScene().getWindow().hide();
            System.out.println("Настройки будут сохранены");
        }

    }

    /**
     * Метод просто скрывает окно, тем самым освобождая поток для дальнейшего отрабатывания программы.
     * @param actionEvent
     */
    public void saveButton(ActionEvent actionEvent) {
        Node node = (Node)actionEvent.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.hide();
    }

    /**
     *  срабатывание кнопки закрытия (просто скрываем окно)
     * @param actionEvent
     */
    public void cancelledButton(ActionEvent actionEvent) {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
    }

    /**
     *
     * @return Возвращаем стринговое значение адреса сервера, через точку или ДНС имя.
     */
    public String getAddressServer() {
        String adrServ = addressServer.getText();
        return adrServ;
    }

    /**
     *
     * @return Возвращаем стринговое значение порта сервера подключения.
     */
    public String getPortServer() {
        String port = portServer.getText();
        return port;
    }

    /**
     *
     * @return Возвращаем значение false если не надо сохранять настройки и true если надо.
     */
    public boolean getSaveSettings(){
        return checkBoxSaveChBx.isSelected();
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
