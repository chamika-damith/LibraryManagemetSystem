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
import org.example.bo.BOFactory;
import org.example.bo.custom.UserBO;
import org.example.dto.BookDto;
import org.example.dto.UserDto;

public class UserFormController {
    public JFXTextField txtUseId;
    public JFXTextField txtUserName;
    public JFXTextField txtUserMail;
    public JFXTextField txtUserPassword;
    public TableView UserTable;
    public JFXTextField txtSearchBar;

    private UserBO userBO= (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.USER);

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
        }else {

            boolean b = userBO.addUser(new UserDto(txtUseId.getText(), txtUserName.getText(), txtUserMail.getText(), txtUserPassword.getText()));


            if (b){
                Image image=new Image("/assest/icon/iconsOk.png");
                try {
                    Notifications notifications=Notifications.create();
                    notifications.graphic(new ImageView(image));
                    notifications.text("User add success");
                    notifications.title("success");
                    notifications.hideAfter(Duration.seconds(5));
                    notifications.position(Pos.TOP_RIGHT);
                    notifications.show();
                }catch (Exception e){
                    e.printStackTrace();
                }
                clearField();
                System.out.println("user add success");
            }
        }
    }

    public void btnUpdateUserOnAction(ActionEvent actionEvent) {
        if (isEmptyCheck()){
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
        }else {
            boolean b = userBO.updateUser(new UserDto(txtUseId.getText(), txtUserName.getText(), txtUserMail.getText(), txtUserPassword.getText()));


            if (b) {
                Image image = new Image("/assest/icon/iconsOk.png");
                try {
                    Notifications notifications = Notifications.create();
                    notifications.graphic(new ImageView(image));
                    notifications.text("Book update success");
                    notifications.title("Warning");
                    notifications.hideAfter(Duration.seconds(5));
                    notifications.position(Pos.TOP_RIGHT);
                    notifications.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                clearField();
                System.out.println("book update success");
            }
        }
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

    private void clearField(){
        txtUserName.clear();
        txtUserPassword.clear();
        txtUserMail.clear();
    }
}
