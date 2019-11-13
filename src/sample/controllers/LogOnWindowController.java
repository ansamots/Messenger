package sample.controllers;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class LogOnWindowController extends Application {

    /**
     *  Метод старт запускается после отрабатывания метода launch.
     *  Здесь рисуется окно для входа в систему
     * @param primaryStage Сцена для отображения окна входа в сисетму
     * @throws Exception Нужен для отлавливания исключений если FXML файл небул нйден
     */

    @Override
    public void start(Stage primaryStage) throws Exception{
//        FXMLLoader loaders = new FXMLLoader();// можно загружать через FXMLLoader
//        loaders.setLocation(Main.class.getResource("/sample/fxmlFiles/LogOnWondowFXML.fxml")); // Тогда надо совмещать с 26 строчкой.
        Parent root = FXMLLoader.load(getClass().getResource("/sample/fxmlFiles/LogOnWondowFXML.fxml"));
//        root = loaders.load(); // Загружать можно и через FXMLLoader.
//        primaryStage = primaryStage1;
        primaryStage.setTitle("NeNeMa Systems");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public void launcher(){ // стандартный метод для запуска JavaFX приложения
        launch();
    }

    @FXML
    private TextField logonField; // поле для ввода логина

    @FXML
    private TextField passwordField; // поле для ввода пароля

    @FXML
    private Label loginStar; // Иконка красной звёздочки для подсветки поля логина

    @FXML
    private Label passwordStar; // Иконка красной звёздочки для подсветки поля пароля

    @FXML
    private Label informationLg; // Иконка информационного сообщения

    /**
     * Метод ля отрабатывания нажатия кнопки Вход
     */
    @FXML
    public void logInButton(){

        System.out.println("Press button LogIn");
        String login = logonField.getText();
        String password = passwordField.getText();
        System.out.println(login + " " + password);
        if (login.equals("") || password.equals("")){ // если поля пустыа то выводим надпись
            markFields(); // здесь метод вывода надписи
        }else {
            System.out.println("Пошла проверка");
            clearFields();
        }

    }

    /**
     * Метод для отрабатывания нажатия кнопки Настройки
     */
    @FXML
    public void settingsButton(ActionEvent actionEvent) { // событие вызова потребуется для получения ссылки на stage.
        System.out.println("Press button Settings");
        SettingsWindowController set = new SettingsWindowController();
        try {
            set.start();
            ((Node)actionEvent.getSource()).getScene().getWindow().hide(); //Скрываем окно входа в систему

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Метод ля отрабатывания нажатия кнопки Регистрация
     */
    @FXML
    public void registeredButton() {
        System.out.println("Press button Regidtered");
    }

    private void markFields(){ //Метод для выделения строк когда они пустые
        loginStar.setText("*");
        passwordStar.setText("*");
        informationLg.setText("Введены пустые данные");
    }

    private void clearFields(){// метод для очищения помеченых строк при пустом вводе
        loginStar.setText("");
        passwordStar.setText("");
        informationLg.setText("");
    }

    private void errorFields(){ // метод для выделения строк при неверном логине и пароле
        loginStar.setText("*");
        passwordStar.setText("*");
        informationLg.setText("Логин и пароль не верны");
    }

    private String hostIP; // Адрес Сервера подклчения
    private String portNumber; //Порт сервера подключения

}
