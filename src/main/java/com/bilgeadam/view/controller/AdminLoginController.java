package com.bilgeadam.view.controller;

import com.bilgeadam.application.Main;
import com.bilgeadam.model.AdminCrudOperations;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        username.setStyle("-fx-text-inner-color: #000000;");
        password.setStyle("-fx-text-inner-color: #000000;");
    }

    @FXML
    public void loginAction(ActionEvent event) {
        progressBar.setVisible(true); // check this line.
        PauseTransition pt = new PauseTransition(Duration.seconds(3));
        pt.setOnFinished(event1 -> {
            try {
                loginController();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        pt.play();

    }

    private void loginController() throws IOException {
        Boolean isAdmin = AdminCrudOperations.getInstance().adminLoginScreen(username.getText(), password.getText());
        if (!isAdmin) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setHeaderText("Username or Password Is Incorrect");
            alert.setContentText("Please Try Again");
            alert.show();
            progressBar.setVisible(false);
        } else {
            login.getScene().getWindow().hide();
            Main main = new Main();
            Stage adminStage = main.getPrimaryStage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/AdminHomePage.fxml"));
            Scene scene = new Scene(root);
            adminStage.setScene(scene);
            adminStage.show();
            adminStage.setResizable(false);
        }
    }

    @FXML
    public void signUpAction(ActionEvent event) throws IOException {
        login.getScene().getWindow().hide();
        Main main = new Main();
        Stage adminStage = main.getPrimaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/SignUp.fxml"));
        Scene scene = new Scene(root);
        adminStage.setScene(scene);
        adminStage.show();
        adminStage.setResizable(false);
    }

}
