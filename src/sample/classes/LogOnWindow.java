package sample.classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controllers.LogOnWindowController;

public class LogOnWindow extends Application {

    /**
     *  Метод старт запускается после отрабатывания метода launch.
     *  Здесь рисуется окно для входа в систему
     * @param primaryStage Сцена для отображения окна входа в сисетму
     * @throws Exception Нужен для отлавливания исключений если FXML файл небыл найден
     */

    @Override
    public void start(Stage primaryStage) {
        try{
            FXMLLoader loaders = new FXMLLoader();
            loaders.setLocation(Main.class.getResource("/sample/fxmlFiles/LogOnWondowFXML.fxml"));
            Parent root = loaders.load();
            logOnController = loaders.getController();
            stage = new Stage();
            stage.setTitle("NeNeMa Systems 1");
            stage.setScene(new Scene(root));
            existsSettings(); // Предварительная проверка на сохранённые настройки для полключение к серверу
            stage.showAndWait(); //Ожидаем, пока окно открыто, дальше код не выполняется.
            if (logOnController.getButtonPressed() != null){ // Если сразу нажать на кремтик, то программа вываливается в ошибку
                // проверка - это решение.
                actionWindow(); // Запускаем метод, который опредиляет, какая кнопка в классеКонструкторе была нажата
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

    /**
     * Метод проверяет, существует ли файл с настройками для подключения к серверу
     * если такой файл есть, то передаёт данные для отображения в окне
     */
    private void existsSettings(){
        SaveSettingsClient setClient = new SaveSettingsClient();
        if(setClient.isFileExists()){
            logOnController.setHostIP(setClient.getIP());
            logOnController.setPortNumber(setClient.getPort());
            logOnController.drawServerAdress();
        }
    }

    /**
     * Метод нужен для отрабатывания дальнейших действие необходимых при логине
     * Он отрабатывает на снове полученого через геттер значения String из контроллера mainController
     */
    private void actionWindow(){
        controllerAnswer = logOnController.getButtonPressed();
        if(controllerAnswer.equals("Login")){
            logOnController.setButtonPressed();
            System.out.println("Отработала кнопка логин");
            login();
        }else if(controllerAnswer.equals("Settings")){
            logOnController.setButtonPressed();
            settings();
        }else if (controllerAnswer.equals("Register")) {
            logOnController.setButtonPressed();
            register();
        }else {
//            System.out.println("завершение программы - из цикла");
            stage.close();
        }
    }

    /**
     * Запускаем метод для входа в систему, с проверкой логина и пароля на сервере.
     */
    private void login(){
        ConnectServer conServ = new ConnectServer(logOnController.getHostIP(), logOnController.getPortNumber(), logOnController.getLogin(),
                                                  logOnController.getPassword());
        conServ.start();
        System.out.println("Отработал метод логин");
        stage.showAndWait(); // показвааем окно входа в систему снова.
//        controllerAnswer.
        actionWindow(); // Запускаем метод, который опредиляет, какая кнопка в классе Контроллере была нажата
        if(conServ.results()){
            
        }
    }

    /**
     * Запускаем класс с окном для ввода адреса и порта сервера.
     */
    private void settings(){
        SettingsWindow settingsWindow = new SettingsWindow(); // запускаем класс для настроек сервера и порта
        settingsWindow.start();
        if(!settingsWindow.isExitProgram()){ // Возвращает true когда программа закрыта, поэтому стоит отрицание - !
            logOnController.setHostIP(settingsWindow.getParametorIP());
            logOnController.setPortNumber(settingsWindow.getParametorPort());
            logOnController.drawServerAdress();
            if(settingsWindow.getSaveSettings()){
                new SaveSettingsClient(settingsWindow.getParametorIP(), settingsWindow.getParametorPort());
            }
            stage.showAndWait(); // показвааем окно входа в систему снова.
            actionWindow(); // Запускаем метод, который опредиляет, какая кнопка в классе Контроллере была нажата
        }
    }

    /**
     * метод отображает web форму для регистрации в приложении.
     */
    private void register(){

    }

    /**
     * стандартный метод для запуска JavaFX приложения
     */
    public void launcher(){
        launch();
    }

    LogOnWindowController logOnController; // Экземпляр контроллера

    private String controllerAnswer; // переменная для отрабатывания методов нажатия кнопок в контроллере
    private String classesAnswer; // переменная получает ответ из других классов для передачи ответа в контроллер
    private Stage stage; // Вынели Stage в класс для управлением скрытия и появления окна
}