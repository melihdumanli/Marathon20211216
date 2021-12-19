package com.bilgeadam.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage pStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initLayout(primaryStage);
        primaryStage.setTitle("Record Store");
        pStage = primaryStage;
    }

    private void initLayout(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../Login.fxml"));
            Scene scene = new Scene(root,800,600);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage(){
        return pStage;
    }
}
