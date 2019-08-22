package sample.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class LogOnWindowController {
    @FXML
    private TextField logonField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label loginStar;

    @FXML
    private Label passwordStar;

    @FXML
    private Label informationLg;

    @FXML
    public void logInButton(){

        System.out.println("Press button LogIn");
        String login = logonField.getText();
        String password = passwordField.getText();
        System.out.println(login + " " + password);
        if (login.equals("") || password.equals("")){
            markFields();
        }else {
            System.out.println("Пошла проверка");
            clearFields();
        }

    }

    @FXML
    public void settingsButton() {
        System.out.println("Press button Settings");
    }

    @FXML
    public void registeredButton() {
        System.out.println("Press button Regidtered");
    }

    private void markFields(){
        loginStar.setText("*");
        passwordStar.setText("*");
        informationLg.setText("Введены пустые данные");
    }

    private void clearFields(){
        loginStar.setText("");
        passwordStar.setText("");
        informationLg.setText("");
    }

}
