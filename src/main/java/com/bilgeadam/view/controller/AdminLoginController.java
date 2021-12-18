package com.bilgeadam.view.controller;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminLoginController implements Initializable {

    @FXML
    private Button admin;

    @FXML
    private Button forgotPassword;

    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private ImageView progressBar;

    @FXML
    private CheckBox rememberMe;

    @FXML
    private Button signUp;

    @FXML
    private TextField username;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        progressBar.setVisible(false);
        username.setStyle("-fx-text-inner-color: #a0a2ab;");
        password.setStyle("-fx-text-inner-color: #a0a2ab;");
    }

    @FXML
    public void loginAction(ActionEvent event) {
        progressBar.setVisible(true);
        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.play();

        progressBar.setVisible(false);


    }

    @FXML
    public void signUpAction(ActionEvent event) throws IOException {
        login.getScene().getWindow().hide();

        Stage signup = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../SignUP.fxml"));
        Scene scene = new Scene(root);
        signup.setScene(scene);
        signup.show();
        signup.setResizable(false);
    }

}
