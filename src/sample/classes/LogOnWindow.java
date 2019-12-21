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
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loaders = new FXMLLoader();
        loaders.setLocation(Main.class.getResource("/sample/fxmlFiles/LogOnWondowFXML.fxml"));
        Parent root = loaders.load();
        logOnController = loaders.getController();

        stage = new Stage();
        stage.setTitle("NeNeMa Systems 1");
        stage.setScene(new Scene(root));
        stage.showAndWait();

        actionWindow();




    }

    /**
     * Метод нужен для отрабатывания дальнейших действие необходимых при логине
     * Он отрабатывает на снове полученого через геттер значения String из контроллера mainController
     */
    private void actionWindow(){
        controllerAnswer = logOnController.getButtonPressed();
        if(controllerAnswer.equals("Login")){
            login();
        }else if(controllerAnswer.equals("Settings")){
            settings();
        }else {
            register();
        }
    }

    private void login(){

    }

    private void settings(){
        SettingsWindow settingsWindow = new SettingsWindow(); // запускаем класс для настроек сервера и порта
        settingsWindow.start();

    }

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
