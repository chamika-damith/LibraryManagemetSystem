package org.example.controller.admin.loginPages;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.controller.WelcomeFormController;

import java.io.IOException;

public class AdminLoginFromController {
    public AnchorPane adminLoginRoot;

    public void btnAdminLoginOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/view/Admin/AdminDashboard.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
