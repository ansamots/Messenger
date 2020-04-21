package sample.controllers;

import interfaces.Mediator;
import interfaces.Notifying;
import interfaces.implementation.MediarotImplementation;
import interfaces.implementation.NotifyingImplementation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.classes.SaveSettingsClient;

import static javafx.scene.paint.Color.GREEN;


public class LogOnWindowController extends NotifyingImplementation {
    /**
     * В конструкторе отправляем ссылку на себя тем самым регистрируемся в медиаторе.
     */
    public LogOnWindowController(){
        super();
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

    @FXML
    private Label ServerAdress; // отображает адрес подключения к серверу


    /**
     * Метод ля отрабатывания нажатия кнопки Вход
     */
    @FXML
    private void logInButton(ActionEvent actionEvent){
        String login = logonField.getText();
        String password = passwordField.getText();
        System.out.println(login + " " + password);
        if (login.equals("") || password.equals("")){ // если поля пустыа то выводим надпись
            markFields(); // здесь метод вывода надписи
        }else {
            clearFields();
            addMessage("Login");
            Node node = (Node)actionEvent.getSource(); // Получаем объект Нода
            Stage stage = (Stage)node.getScene().getWindow(); // Приравниваем ноду к сцене
//            stage.hide(); // Скрываем текущее окно (сцену).
        }
    }

    /**
     * Метод для отрабатывания нажатия кнопки Настройки
     */
    @FXML
    private void settingsButton(ActionEvent actionEvent) { // событие вызова потребуется для получения ссылки на stage.
        addMessage("Settings"); //Передаём медиатору сообщение о нажатой кнопке
        Node node = (Node)actionEvent.getSource(); // Получаем объект Нода
        Stage stage = (Stage)node.getScene().getWindow(); // Приравниваем ноду к сцене
        stage.hide(); // Скрываем текущее окно (сцену).
    }

    /**
     * Метод ля отрабатывания нажатия кнопки Регистрация
     */
    @FXML
    private void registeredButton() {
        System.out.println("Press button Registered");
    }

    /**
     * В этом методе ми иничиаличируем поля, при помощи которых определяем,
     * есть ли данные по серверу.
     * Необходимость использовать этот етод в том, что если попытаться проверить это в
     * конструкторе вылетает ошибка загрузки и программа виснет.
     */
    @FXML
    private void initialize(){
        existsSettings();
    }

    /**
     * Метод проверяет, существует ли файл с настройками для подключения к серверу
     * если такой файл есть, то передаёт данные для отображения в окне
     */
    private void existsSettings(){
        SaveSettingsClient setClient = new SaveSettingsClient();
        if(setClient.isFileExists()){
            hostIP = setClient.getIP();
            portNumber = setClient.getPort();
            drawServerAdress();
        }
    }

    /**
     * Метод для выделения строк когда они пустые
     */
    private void markFields(){
        loginStar.setText("*");
        passwordStar.setText("*");
        informationLg.setText("Введены пустые данные");
    }

    /**
     * Метод для очищения помеченых строк при пустом вводе
     */
    private void clearFields(){
        loginStar.setText("");
        passwordStar.setText("");
        informationLg.setText("");
    }

    /**
     * метод для выделения строк при неверном логине и пароле
     */
    private void errorFields(){
        loginStar.setText("*");
        passwordStar.setText("*");
        informationLg.setText("Логин и пароль не верны");
    }


    /**
     * Отрисоввываем на главном окне адрес подключения к серверу.
     */
    public void drawServerAdress(){
        ServerAdress.setText(hostIP+":"+portNumber);
        ServerAdress.setTextFill(GREEN);
    }

    /**
     * Геттер для логина
     */
    public String getHostLogin() {
        return logonField.getText();
    }

    /**
     * Геттер для пароля
     */
    public String getHostPassword() {
        return passwordField.getText();
    }

    public String getHostIP(){
        return hostIP;
    }

    public String getPortNumber(){
        return portNumber;
    }

    /**
     * Получаем сообщение от медиатора.
     */
    public void setMessage(String message) {
        System.out.println("Получено сообщение от Медиатора: "+message);
        if(message.equals("true")){
            deleteMe(); // Удаляем укземпляр из Медиатора, т.к. прошла аунтентификация.
        }
        if(message.equals("false")){
            errorFields();
        }
    }


    private String hostIP; // Адрес Сервера подклчения
    private String portNumber; //Порт сервера подключения
    private String buttonPressed; // Переменная нужна для определения нажатой кнопки
}