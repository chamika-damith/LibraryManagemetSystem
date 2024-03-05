package org.example.controller.admin.userPages;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class UserFormController {
    public JFXTextField txtUseId;
    public JFXTextField txtUserName;
    public JFXTextField txtUserMail;
    public JFXTextField txtUserPassword;
    public TableView UserTable;
    public JFXTextField txtSearchBar;

    public void btnAddUserOnAction(ActionEvent actionEvent) {
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

    public void btnUpdateUserOnAction(ActionEvent actionEvent) {
    }

    public void btnSearchUserOnAction(ActionEvent actionEvent) {
    }

    private boolean isEmptyCheck() {

        if(txtUseId.getText().isEmpty()){
            txtUseId.requestFocus();
            txtUseId.setFocusColor(Color.RED);
            System.out.println("user id field is empty");
            return true;
        }
        if(txtUserName.getText().isEmpty()){
            txtUserName.requestFocus();
            txtUserName.setFocusColor(Color.RED);
            System.out.println("user name field is empty");
            return true;
        }
        if (txtUserMail.getText().isEmpty()){
            txtUserMail.requestFocus();
            txtUserMail.setFocusColor(Color.RED);
            System.out.println("user mail field is empty");
            return true;
        }
        if (txtUserPassword.getText().isEmpty()){
            txtUserPassword.requestFocus();
            txtUserPassword.setFocusColor(Color.RED);
            System.out.println("user password field is empty");
            return true;
        }
        return false;
    }
}
