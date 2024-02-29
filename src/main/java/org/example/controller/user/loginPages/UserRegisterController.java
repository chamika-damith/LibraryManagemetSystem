package org.example.controller.user.loginPages;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UserRegisterController {
    public AnchorPane userRegisterRoot;

    public void userLoginOnAction(MouseEvent mouseEvent) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/view/user/loginPages/UserLoginForm.fxml"));
        userRegisterRoot.getChildren().clear();
        userRegisterRoot.getChildren().add(parent);
    }
}
