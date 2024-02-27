package org.example.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class WelcomeFormController {
    public AnchorPane welcomeRoot;
    public JFXButton btnUser;

    public void initialize() throws IOException {
        Parent parent=FXMLLoader.load(getClass().getResource("/view/loginPages/UserLoginForm.fxml"));
        welcomeRoot.getChildren().clear();
        welcomeRoot.getChildren().add(parent);

        btnUser.setStyle("-fx-border-color: black");
    }

    public void btnUserLoginOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent=FXMLLoader.load(getClass().getResource("/view/loginPages/UserLoginForm.fxml"));
        welcomeRoot.getChildren().clear();
        welcomeRoot.getChildren().add(parent);

        btnUser.setStyle("-fx-border-color:  black");
    }
}
