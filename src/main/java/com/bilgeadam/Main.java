package com.bilgeadam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initLayout(primaryStage);
    }

    private void initLayout(Stage primaryStage) {
        try {
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("view/main/LoginPage.FXML"));
            Scene scene = new Scene(root,600,800);
            scene.getStylesheets().add(getClass().getResource("view/main/application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void showMainView(){
        FXMLLoader loader = new FXMLLoader();


    }
}
