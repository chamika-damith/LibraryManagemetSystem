package org.example.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UserDashboardController {
    public AnchorPane changeRoot;

    public void btnBookOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/view/user/bookPages/AllBookForm.fxml"));
        changeRoot.getChildren().clear();
        changeRoot.getChildren().add(parent);
    }

    public void btnBorrowBooksOnAction(ActionEvent actionEvent) {
    }

    public void btnTransactionOnAction(ActionEvent actionEvent) {
    }

    public void btndashboardOnAction(ActionEvent actionEvent) {
    }
}
