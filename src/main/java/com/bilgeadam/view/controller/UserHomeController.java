package com.bilgeadam.view.controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Ref;
import java.util.ResourceBundle;

public class UserHomeController implements Initializable {
    @FXML
    private Button cdButton;

    @FXML
    private Button dvdButton;

    @FXML
    private Button vinylButton;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void delCdButtonEffects(MouseEvent event) {
        cdButton.setUnderline(false);
        cdButton.setEffect(null);
    }

    @FXML
    void delDvdButtonEffects(MouseEvent event) {
        dvdButton.setUnderline(false);
        dvdButton.setEffect(null);
    }

    @FXML
    void delVinylButtonEffects(MouseEvent event) {
        vinylButton.setUnderline(false);
        vinylButton.setEffect(null);
    }

    @FXML
    void setCdButtonEffects(MouseEvent event) {
        cdButton.setUnderline(true);
        Reflection r = new Reflection();
        r.setBottomOpacity(0.0);
        r.setTopOpacity(0.5);
        r.setTopOffset(0);
        r.setFraction(0.25);
        cdButton.setEffect(r);
    }

    @FXML
    void setDvdButtonEffects(MouseEvent event) {
        dvdButton.setUnderline(true);
        Reflection r = new Reflection();
        r.setBottomOpacity(0.0);
        r.setTopOpacity(0.5);
        r.setTopOffset(0);
        r.setFraction(0.25);
        dvdButton.setEffect(r);
    }

    @FXML
    void setVinylButtonEffects(MouseEvent event) {
        vinylButton.setUnderline(true);
        Reflection r = new Reflection();
        r.setBottomOpacity(0.0);
        r.setTopOpacity(0.5);
        r.setTopOffset(0);
        r.setFraction(0.25);
        vinylButton.setEffect(r);
    }
}
