package sample.classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LogOnWindowClass extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
//        FXMLLoader loaders = new FXMLLoader();// можно загружать через FXMLLoader
//        loaders.setLocation(Main.class.getResource("/sample/fxmlFiles/LogOnWondowFXML.fxml")); // Тогда надо соввесчать с 19 строчкой.
        Parent root = FXMLLoader.load(getClass().getResource("/sample/fxmlFiles/LogOnWondowFXML.fxml"));
//        root = loaders.load(); // Загружать можно и через FXMLLoader.
        primaryStage.setTitle("NeNeMa Systems");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void launcher(){
        launch();
    }

}
