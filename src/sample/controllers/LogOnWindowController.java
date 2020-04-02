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
    public LogOnWindowController(){
        super(MediarotImplementation.getMediator());
        mediator.addUsers(this);
//        existsSettings();

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
            mediator.notifyUsers("Нажата кнопка Логина."); //Передаём медиатору сообщение о нажатой кнопке
            buttonPressed = ("Login");// присваиваем переменной значение нажатой кнопки
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
        System.out.println("Press button Settings");
        buttonPressed = ("Settings");// присваиваем переменной значение нажатой кнопки
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

//    /**
//     * возвращием определение нажатой кнопки
//     */
//    public String getButtonPressed() {
//        return buttonPressed;
//    }

//    /**
//     * метод для сбрасывания значения ранее нажатой кнопки
//     * Нужен для того, что бы программа не падала в бесконечный цикл
//     * P.S. - (потом разобраться как обойти эту проблему, скорее всего не правильно изначально залажил
//     *         концепцию разработки с скрыванием окон. Посмотреть в сторону XML для прямого взаимодействия
//     *         с классами.)
//     */
//    public void setButtonPressed(){
//        buttonPressed = "null";
//    }

    /**
     * метод нужен для того, что бы видеть в стартовом окне, к какому серверу идёт подключение
     * @param hostIP - в этом методе указываем IP или DNS имя сервера.
     */
    public void setHostIP(String hostIP) {
        this.hostIP = hostIP;
    }

    public String getHostIP(){
        return hostIP;
    }

//    /**
//     * метод нужен для того, что бы видеть в стартовом окне, к какому серверу идёт подключение
//     * @param portNumber - в этом методе указываем порт сервера.
//     */
//    public void setPortNumber(String portNumber){
//        this.portNumber = portNumber;
//    }
//
//    public String getPortNumber(){
//        return portNumber;
//    }

    /**
     * Отрисоввываем на главном окне адрес подключения к серверу.
     */
    public void drawServerAdress(){
        ServerAdress.setText(hostIP+":"+portNumber);
        ServerAdress.setTextFill(GREEN);
    }

    public String getLogin(){
        return logonField.getText();
    }

    public String getPassword(){
        return passwordField.getText();
    }

    /**
     * Уведомляем медиатора.
     */
    public void addMessage(String message) {
        mediator.notifyUsers(message);
    }

    /**
     * Получаем сообщение от медиатора.
     */
    public void setMessage(String message) {
        System.out.println("Получено сообщение от Медиатора: "+message);
    }

    private String hostIP; // Адрес Сервера подклчения
    private String portNumber; //Порт сервера подключения
    private String buttonPressed; // Переменная нужна для определения нажатой кнопки
}