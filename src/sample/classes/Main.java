package sample.classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import sample.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        FXMLLoader loaders = new FXMLLoader();// можно загружать через FXMLLoader
//        loaders.setLocation(Main.class.getResource("/sample/fxmlFiles/sample.fxml")); // Тогда надо соввесчать с 19 строчкой.
        Parent root = FXMLLoader.load(getClass().getResource("/sample/fxmlFiles/sample.fxml"));
//        root = loaders.load(); // Загружать можгл и через FXMLLoader.
        primaryStage.setTitle("NeNeMa Systems");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
