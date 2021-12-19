package com.bilgeadam.view.controller;

import com.bilgeadam.application.Main;
import com.bilgeadam.model.CustomerEntity;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private TextField address;

    @FXML
    private TextField email;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton genderFemale;

    @FXML
    private RadioButton genderMale;

    @FXML
    private RadioButton genderOther;

    @FXML
    private Button login;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phone;

    @FXML
    private Button signupButton;

    @FXML
    private TextField surname;

    @FXML
    private TextField username;

    public static CustomerEntity customer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setStyle("-fx-text-inner-color: #a0a2ab;");
        password.setStyle("-fx-text-inner-color: #a0a2ab;");
        address.setStyle("-fx-text-inner-color: #a0a2ab;");
    }

    @FXML
    public void signUp(ActionEvent event1) throws IOException {
        PauseTransition delay = new PauseTransition(Duration.seconds(0.5));
        delay.play();

        customer = new CustomerEntity();
        customer.setName(name.getText());
        customer.setSurname(surname.getText());
        customer.setUsername(username.getText());
        customer.setPassword(password.getText());
        customer.setEmail(email.getText());
        customer.setPhone(phone.getText());
        customer.setAddress(address.getText());
        customer.setGender(getGender());
        /*customerController = new CustomerController();
        customerController.create(customer);*/

        signupButton.getScene().getWindow().hide();
        Main main = new Main();
        Stage verificationStage = main.getPrimaryStage();
        verificationStage.setTitle("Verification");
        Parent root = FXMLLoader.load(getClass().getResource("../Verification.fxml"));
        verificationStage.setScene(new Scene(root));
        verificationStage.show();
        verificationStage.setResizable(false);
    }

    @FXML
    public void login(ActionEvent event2) throws IOException {
        signupButton.getScene().getWindow().hide();
        Main main = new Main();
        Stage loginStage = main.getPrimaryStage();
        loginStage.setTitle("Login");
        Parent root = FXMLLoader.load(getClass().getResource("../../Login.fxml"));
        loginStage.setScene(new Scene(root));
        loginStage.show();
        loginStage.setResizable(false);
    }

    public String getGender() {
        String gender ="";
        if (genderMale.isSelected())
            gender = "Male";
        else if (genderFemale.isSelected())
            gender = "Female";
        else if (genderOther.isSelected())
            gender = "Other";
        return gender;
    }
}
