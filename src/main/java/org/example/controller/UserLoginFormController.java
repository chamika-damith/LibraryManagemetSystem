package org.example.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UserLoginFormController {
    public AnchorPane userLoginRoot;

    public void userRegisterOnAction(MouseEvent mouseEvent) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/view/user/loginPages/UserRegisterForm.fxml"));
        userLoginRoot.getChildren().clear();
        userLoginRoot.getChildren().add(parent);
    }
}
