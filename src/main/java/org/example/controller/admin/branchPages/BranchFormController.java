package org.example.controller.admin.branchPages;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class BranchFormController {
    public JFXTextField txtBranchId;
    public JFXTextField txtBranchName;
    public JFXTextField txtBranchLocation;
    public TableView branchTable;
    public TableColumn colBranchId;
    public TableColumn colBranchName;
    public TableColumn colBranchLocation;
    public TableColumn colCloseBranch;
    public JFXTextField txtSearchBar;

    public void btnAddBranchOnAction(ActionEvent actionEvent) {
        if(isEmptyCheck()){
            Image image=new Image("/assest/icon/icons8-cancel-50.png");
            try {
                Notifications notifications=Notifications.create();
                notifications.graphic(new ImageView(image));
                notifications.text("Value is empty! Please enter all values");
                notifications.title("Warning");
                notifications.hideAfter(Duration.seconds(5));
                notifications.position(Pos.TOP_RIGHT);
                notifications.show();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void btnUpdateBranchOnAction(ActionEvent actionEvent) {
    }

    public void btnSearchBranchOnAction(ActionEvent actionEvent) {
    }

    private boolean isEmptyCheck() {

        if(txtBranchId.getText().isEmpty()){
            txtBranchId.requestFocus();
            txtBranchId.setFocusColor(Color.RED);
            System.out.println("Branch id field is empty");
            return true;
        }
        if(txtBranchName.getText().isEmpty()){
            txtBranchName.requestFocus();
            txtBranchName.setFocusColor(Color.RED);
            System.out.println("Branch name field is empty");
            return true;
        }
        if (txtBranchLocation.getText().isEmpty()){
            txtBranchLocation.requestFocus();
            txtBranchLocation.setFocusColor(Color.RED);
            System.out.println("Branch location field is empty");
            return true;
        }
        return false;
    }
}
