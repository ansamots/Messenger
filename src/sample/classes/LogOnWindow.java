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
     * @throws Exception Нужен для отлавливания исключений если FXML файл небул нйден
     */

    @Override
    public void start(Stage primaryStage) throws Exception{
//        FXMLLoader loaders = new FXMLLoader();// можно загружать через FXMLLoader
//        loaders.setLocation(Main.class.getResource("/sample/fxmlFiles/LogOnWondowFXML.fxml")); // Тогда надо совмещать с 26 строчкой.
        Parent root = FXMLLoader.load(getClass().getResource("/sample/fxmlFiles/LogOnWondowFXML.fxml"));
//        root = loaders.load(); // Загружать можно и через FXMLLoader.
//        primaryStage = primaryStage1;
        stage = new Stage();
        stage.setTitle("NeNeMa Systems 1");
        stage.setScene(new Scene(root));
        stage.show();
//        primaryStage.setTitle("NeNeMa Systems");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();

    }

    public void launcher(){ // стандартный метод для запуска JavaFX приложения
        launch();
    }

    private void setTitel(){

    }

    private Stage stage;

}
