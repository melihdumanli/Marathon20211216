package com.bilgeadam.view.controller;

import com.bilgeadam.application.Main;
import com.bilgeadam.controller.CustomerController;
import com.bilgeadam.model.UserCrudOperations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;


public class VerificationController implements Initializable {

    @FXML
    private Button submit;

    @FXML
    private TextField verCode;

    private UserCrudOperations userCrudOperations;
    private CustomerController customerController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userCrudOperations = new UserCrudOperations();
        userCrudOperations.verCodeGenerator();
    }

    @FXML
    void verificationAction(ActionEvent event) throws IOException {

        Boolean check = userCrudOperations.verCodeChecker(verCode.getText());
        do {
            if(check){
                customerController = new CustomerController();
                LoginController.customerEntity.setLogDate(LocalDateTime.now());
                LoginController.customerEntity.setActive(true);
                customerController.create(LoginController.customerEntity);
                submit.getScene().getWindow().hide();
                Main main = new Main();
                Stage userStage = main.getPrimaryStage();
                userStage.setTitle("UserHomePage");
                Parent root = FXMLLoader.load(getClass().getResource("../fxml/UserHomePage.fxml"));
                userStage.setScene(new Scene(root));
                userStage.show();
                userStage.setResizable(false);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setHeaderText("Verification Code Is Incorrect");
                alert.setContentText("Please Try Again");
                alert.show();
                verCode.setText("");
            }
        } while (!check);
    }
}
