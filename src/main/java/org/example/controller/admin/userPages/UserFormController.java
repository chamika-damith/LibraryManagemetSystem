package org.example.controller.admin.userPages;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.TextFields;
import org.example.bo.BOFactory;
import org.example.bo.custom.UserBO;
import org.example.dto.BookDto;
import org.example.dto.UserDto;
import org.example.dto.tm.BooksTm;
import org.example.dto.tm.UserTm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserFormController {
    public JFXTextField txtUseId;
    public JFXTextField txtUserName;
    public JFXTextField txtUserMail;
    public JFXTextField txtUserPassword;
    public TableView userTable;
    public JFXTextField txtSearchBar;
    public TableColumn colUserid;
    public TableColumn colUserName;
    public TableColumn colUserMail;
    public TableColumn colBtnRemove;

    private UserBO userBO= (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.USER);

    private ObservableList<UserTm> obList;

    public void initialize(){
        userTable.getStylesheets().add("/style/style.css");
        setCellValue();
        getAllUsers();
        //searchTable();
    }

    private void setCellValue() {
        colUserid.setCellValueFactory(new PropertyValueFactory<>("userId"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colUserMail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colBtnRemove.setCellValueFactory(new PropertyValueFactory<>("remove"));
    }

    private void getAllUsers(){
        obList= FXCollections.observableArrayList();
        List<UserDto> allUser = userBO.getAllUser();
        List<String> suggestionList = new ArrayList<>();

        for (UserDto dto: allUser){
            suggestionList.add(String.valueOf(dto.getUserId()));

            Button buttonRemove=createRemoveButton();

            obList.add(new UserTm(
                    dto.getUserId(),
                    dto.getUserName(),
                    dto.getEmail(),
                    buttonRemove
            ));
        }
        String[] suggestionArray = suggestionList.toArray(new String[0]);
        TextFields.bindAutoCompletion(txtSearchBar, suggestionArray);

        userTable.setItems(obList);
    }

    public Button createRemoveButton(){
        Button btn=new Button("Remove");
        btn.getStyleClass().add("removeBtn");
        btn.setCursor(Cursor.cursor("Hand"));
        setDeleteBtnAction(btn);
        return btn;
    }

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

    private void setDeleteBtnAction(Button btn) {
        btn.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to delete?", yes, no).showAndWait();


            if (type.orElse(no) == yes) {
                int focusedIndex = userTable.getSelectionModel().getSelectedIndex();
                UserTm userTm = (UserTm) userTable.getSelectionModel().getSelectedItem();

                if (userTm != null) {
                    String userId = userTm.getUserId();
                    boolean b = userBO.deleteUser(userId);
                    if (b) {

                        Image image=new Image("/assest/icon/iconsDelete.png");
                        Notifications notifications=Notifications.create();
                        notifications.graphic(new ImageView(image));
                        notifications.text("User Delete Successfully");
                        notifications.title("Successfully");
                        notifications.hideAfter(Duration.seconds(5));
                        notifications.position(Pos.TOP_RIGHT);
                        notifications.show();
                        System.out.println("delete selected");
                        obList.remove(focusedIndex);
                        getAllUsers();
                        //searchTable();
                    }
                }
            }
        });
    }

}
