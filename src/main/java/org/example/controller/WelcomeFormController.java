package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class WelcomeFormController {
    public AnchorPane welcomeRoot;

    public void initialize() throws IOException {
        Parent parent=FXMLLoader.load(getClass().getResource("/view/welcomePages/UserLoginForm.fxml"));
        welcomeRoot.getChildren().clear();
        welcomeRoot.getChildren().add(parent);
    }

    public void btnUserLoginOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent=FXMLLoader.load(getClass().getResource("/view/welcomePages/UserLoginForm.fxml"));
        welcomeRoot.getChildren().clear();
        welcomeRoot.getChildren().add(parent);
    }
}
