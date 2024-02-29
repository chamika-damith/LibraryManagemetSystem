package org.example.controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AdminDashboardController {


    public AnchorPane changeRoot;

    public void initialize() throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/view/Admin/dashboard/DashboardForm.fxml"));
        changeRoot.getChildren().clear();
        changeRoot.getChildren().add(parent);
    }
    public void btndashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/view/Admin/dashboard/DashboardForm.fxml"));
        changeRoot.getChildren().clear();
        changeRoot.getChildren().add(parent);
    }

    public void btnBookOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/view/Admin/booksPages/BookForm.fxml"));
        changeRoot.getChildren().clear();
        changeRoot.getChildren().add(parent);
    }

    public void btnUserOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/view/Admin/userPages/UserForm.fxml"));
        changeRoot.getChildren().clear();
        changeRoot.getChildren().add(parent);
    }

    public void btnTransactionOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/view/Admin/transaction/TransactionForm.fxml"));
        changeRoot.getChildren().clear();
        changeRoot.getChildren().add(parent);
    }

    public void btnBranchesOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/view/Admin/branchPaages/BranchForm.fxml"));
        changeRoot.getChildren().clear();
        changeRoot.getChildren().add(parent);
    }
}
