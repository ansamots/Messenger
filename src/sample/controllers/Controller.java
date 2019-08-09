package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    private TextField logonField;

    @FXML
    private TextField passwordField;

    public void logInButton(ActionEvent actionEvent){

        System.out.println("Press button LogIn");
        String login = logonField.getText();
        String password = passwordField.getText();
        System.out.println(logonField + " "+ passwordField);
        System.out.println(login + " " + password);
    }

    public void settingsButton(ActionEvent actionEvent) {
        System.out.println("Press button Settings");
    }

    public void registeredButton(ActionEvent actionEvent) {
        System.out.println("Press button Regidtered");
    }

}
