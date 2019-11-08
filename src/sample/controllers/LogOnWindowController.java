package sample.controllers;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LogOnWindowController extends Application {
    private Stage primaryStage;

    /**
     *  Метод старт запускается после отрабатывания метода launch.
     *  Здесь рисуется окно для входа в систему
     * @param primaryStage Сцена для отображения окна входа в сисетму
     * @throws Exception Нужен для отлавливания исключений если FXML файл небул нйден
     */

    @Override
    public void start(Stage primaryStage) throws Exception{
//        FXMLLoader loaders = new FXMLLoader();// можно загружать через FXMLLoader
//        loaders.setLocation(Main.class.getResource("/sample/fxmlFiles/LogOnWondowFXML.fxml")); // Тогда надо соввесчать с 19 строчкой.
        Parent root = FXMLLoader.load(getClass().getResource("/sample/fxmlFiles/LogOnWondowFXML.fxml"));
//        root = loaders.load(); // Загружать можно и через FXMLLoader.
        this.primaryStage = primaryStage;
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
        if (login.equals("") || password.equals("")){
            markFields();
        }else {
            System.out.println("Пошла проверка");
            clearFields();
        }

    }

    /**
     * Метод ля отрабатывания нажатия кнопки Настройки
     */
    @FXML
    public void settingsButton() {
        System.out.println("Press button Settings");
        SettingsWindowController set = new SettingsWindowController();

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

}
