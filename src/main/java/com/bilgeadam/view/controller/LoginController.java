package com.bilgeadam.view.controller;

import com.bilgeadam.application.Main;
import com.bilgeadam.model.CustomerEntity;
import com.bilgeadam.model.UserCrudOperations;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public static CustomerEntity customerEntity = new CustomerEntity();
    private static UserCrudOperations userCrudOperations = new UserCrudOperations();
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
    @FXML
    private Button exit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        progressBar.setVisible(false);
        username.setStyle("-fx-text-inner-color: #000000;");
        password.setStyle("-fx-text-inner-color: #000000;");

    }

    @FXML
    public void loginAction(ActionEvent event) {
        progressBar.setVisible(true);
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.play();
        delay.setOnFinished(e -> {
            try {
                loginController();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void loginController() throws IOException {
        Boolean isValid = userCrudOperations.userSignIn(username.getText(), password.getText());

        if (!isValid) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setHeaderText("Username or Password Is Incorrect");
            alert.setContentText("Please Try Again");
            alert.show();
            progressBar.setVisible(false);
        } else {
            login.getScene().getWindow().hide();
            Main main = new Main();
            Stage userStage = main.getPrimaryStage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/UserHomePage.fxml"));
            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.show();
            userStage.setResizable(false);
        }
    }

    @FXML
    public void signUpAction(ActionEvent event) throws IOException {
        login.getScene().getWindow().hide();
        Main main = new Main();
        Stage signup = main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/SignUp.fxml"));
        Scene scene = new Scene(root);
        signup.setScene(scene);
        signup.show();
        signup.setResizable(false);
    }

    @FXML
    public void adminLoginAction(ActionEvent event) throws IOException {
        login.getScene().getWindow().hide();

        Stage adminLogin = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/AdminLogin.fxml"));
        Scene scene = new Scene(root);
        adminLogin.setScene(scene);
        adminLogin.show();
        adminLogin.setResizable(false);
    }

    @FXML
    public void exitUnderline(MouseEvent event) throws IOException {
        exit.setUnderline(true);
    }

    @FXML
    public void exitDelUnderline(MouseEvent event) throws IOException {
        exit.setUnderline(false);
    }

    @FXML
    public void exit(ActionEvent event) throws IOException {
        System.exit(0);
    }

}
