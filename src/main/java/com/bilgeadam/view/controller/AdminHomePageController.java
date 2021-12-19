package com.bilgeadam.view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminHomePageController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button exit;

    @FXML
    private AnchorPane holderPane;

    @FXML
    private Button orderButton;

    @FXML
    private Button showButton;

    @FXML
    private Text welcomeText;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img4;

    @FXML
    private ImageView img5;

    @FXML
    private Text text1;

    @FXML
    private Text text2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        text1.setVisible(false);
        text2.setVisible(false);
    }
    @FXML
    void delAddButtonEffects(MouseEvent event) {
        addButton.setUnderline(false);
        addButton.setEffect(null);
    }

    @FXML
    void delOrderButtonEffects(MouseEvent event) {
        orderButton.setUnderline(false);
        orderButton.setEffect(null);
    }

    @FXML
    void delShowButtonEffects(MouseEvent event) {
        showButton.setUnderline(false);
        showButton.setEffect(null);
    }

    @FXML
    void delButtonEffects(MouseEvent event) {
        deleteButton.setUnderline(false);
        deleteButton.setEffect(null);
    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void exitDelUnderline(MouseEvent event) {
        exit.setUnderline(false);
    }

    @FXML
    void exitUnderline(MouseEvent event) {
        exit.setUnderline(true);
    }

    @FXML
    void setAddButtonEffects(MouseEvent event) {
        addButton.setUnderline(true);
        Reflection r = new Reflection();
        r.setBottomOpacity(0.0);
        r.setTopOpacity(0.5);
        r.setTopOffset(0);
        r.setFraction(0.25);
        addButton.setEffect(r);
    }

    @FXML
    void setDelButtonEffects(MouseEvent event) {
        deleteButton.setUnderline(true);
        Reflection r = new Reflection();
        r.setBottomOpacity(0.0);
        r.setTopOpacity(0.5);
        r.setTopOffset(0);
        r.setFraction(0.25);
        deleteButton.setEffect(r);
    }

    @FXML
    void setOrderButtonEffects(MouseEvent event) {
        orderButton.setUnderline(true);
        Reflection r = new Reflection();
        r.setBottomOpacity(0.0);
        r.setTopOpacity(0.5);
        r.setTopOffset(0);
        r.setFraction(0.25);
        orderButton.setEffect(r);
    }

    @FXML
    void setShowButtonEffects(MouseEvent event) {
        showButton.setUnderline(true);
        Reflection r = new Reflection();
        r.setBottomOpacity(0.0);
        r.setTopOpacity(0.5);
        r.setTopOffset(0);
        r.setFraction(0.25);
        showButton.setEffect(r);
    }

    @FXML
    void underConstruction(ActionEvent event) {
        deleteButton.setVisible(false);
        addButton.setVisible(false);
        orderButton.setVisible(false);
        showButton.setVisible(false);
        img1.setVisible(false);
        img2.setVisible(false);
        img3.setVisible(false);
        img4.setVisible(false);
        img5.setVisible(false);
        text1.setVisible(true);
        text2.setVisible(true);
    }
}
