package sample.classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
//            logOnController = loaders.getController();
            stage = new Stage();
            stage.setTitle("NeNeMa Systems 1");
            stage.setScene(new Scene(root));
//            existsSettings(); // Предварительная проверка на сохранённые настройки для полключение к серверу
//            stage.showAndWait(); //Ожидаем, пока окно открыто, дальше код не выполняется.
            stage.show(); // Показываем окно.
//            if (logOnController.getButtonPressed() != null){ // Если сразу нажать на креcтик, то программа вываливается в ошибку
//                // проверка - это решение.
//                actionWindow(); // Запускаем метод, который опредиляет, какая кнопка в классеКонструкторе была нажата
//            }
        }catch (Exception e){
            System.out.println(e);
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

    private Stage stage; // Вынели Stage в класс для управлением скрытия и появления окна

}