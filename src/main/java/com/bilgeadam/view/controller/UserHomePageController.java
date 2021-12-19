package com.bilgeadam.view.controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserHomePageController implements Initializable {

    @FXML
    private AnchorPane holderPane;

    AnchorPane showAlbumsPane;
    AnchorPane underConstructionPane;

    @FXML
    private Label cartCounter;

    @FXML
    private Text welcomeText;

    @FXML
    private Button exit;

    @FXML
    private Button myCart;

    @FXML
    private Button showAlbums;

    @FXML
    private Button showArtist;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            welcomeText.setText("Welcome, " + LoginController.customerEntity.getName() + " " + LoginController.customerEntity.getSurname() +  ".");

    }

    @FXML
    public void showAlbumsAction(ActionEvent event) throws IOException {
        try {
            showAlbumsPane = FXMLLoader.load(getClass().getResource("../fxml/UserHome.fxml"));
            setNode(showAlbumsPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    public void showAlbumsUnderline(MouseEvent event) throws IOException {
        showAlbums.setUnderline(true);
    }

    @FXML
    public void showArtistsUnderline(MouseEvent event) throws IOException {
        showArtist.setUnderline(true);
    }

    @FXML
    public void myCartUnderline(MouseEvent event) throws IOException {
        myCart.setUnderline(true);
    }

    @FXML
    public void showAlbumsDelUnderline(MouseEvent event) throws IOException {
        showAlbums.setUnderline(false);
    }

    @FXML
    public void showArtistDelUnderline(MouseEvent event) throws IOException {
        showArtist.setUnderline(false);
    }

    @FXML
    public void myCartDelUnderline(MouseEvent event) throws IOException {
        myCart.setUnderline(false);
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

    @FXML
    void underConstruction(ActionEvent event) {
        try {
            underConstructionPane = FXMLLoader.load(getClass().getResource("../fxml/UnderConstruction.fxml"));
            setNode(underConstructionPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
