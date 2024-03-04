package org.example.controller.admin.booksPages;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import javafx.scene.paint.Color;
import org.example.bo.BOFactory;
import org.example.bo.custom.BookBO;
import org.example.dto.BookDto;
import org.example.dto.tm.BooksTm;

import java.util.List;

public class BookFormController {
    public TableView bookTable;
    public JFXTextField bookTitle;
    public JFXTextField bookAuthor;
    public JFXTextField bookGenre;
    public JFXComboBox availabilityStatus;
    public JFXTextField bookId;
    public TableColumn colBookId;
    public TableColumn colTitle;
    public TableColumn colAuthor;
    public TableColumn colGenre;
    public TableColumn colStatus;
    public TableColumn colUpdate;
    public TableColumn colRemove;

    private BookBO bookBO= (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.BOOK);

    private ObservableList<BooksTm> obList;

    public void initialize(){
        bookTable.getStylesheets().add("/style/style.css");
        setAvailableStatus();
        setCellValue();
        getAllBooks();
    }

    private void setCellValue() {
        colBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colRemove.setCellValueFactory(new PropertyValueFactory<>("remove"));

    }

    private void getAllBooks(){
        obList=FXCollections.observableArrayList();
        List<BookDto> allBooks = bookBO.getAllBooks();

        for (BookDto dto: allBooks){
            Button buttonRemove=createRemoveButton();
            String available;
            if (dto.isAvailability()){
                available="available";
            }else{
                available="notAvailable";
            }

            obList.add(new BooksTm(
               dto.getBookId(),
               dto.getTitle(),
               dto.getAuthor(),
               dto.getGenre(),
               available,
               buttonRemove
            ));
        }
        bookTable.setItems(obList);
    }

    public Button createRemoveButton(){
        Button btn=new Button("Remove");
        btn.getStyleClass().add("removeBtn");
        btn.setCursor(Cursor.cursor("Hand"));
        return btn;
    }

    private void setAvailableStatus(){
        ObservableList<String> oblist= FXCollections.observableArrayList();
        oblist.add("available");
        oblist.add("notAvailable");
        availabilityStatus.setItems(oblist);
    }

    public void btnAddBookOnAction(ActionEvent actionEvent) {
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
            String value = (String) availabilityStatus.getValue();
            boolean available;
            if (value.equals("available")){
                available = true;
            }else {
                available=false;
            }

            boolean b = bookBO.updateBook(new BookDto(bookId.getText(), bookTitle.getText(), bookAuthor.getText(),
                    bookGenre.getText(), available));

            if (b){
                Image image=new Image("/assest/icon/iconsOk.png");
                try {
                    Notifications notifications=Notifications.create();
                    notifications.graphic(new ImageView(image));
                    notifications.text("Book add success");
                    notifications.title("Warning");
                    notifications.hideAfter(Duration.seconds(5));
                    notifications.position(Pos.TOP_RIGHT);
                    notifications.show();
                }catch (Exception e){
                    e.printStackTrace();
                }

                getAllBooks();
                System.out.println("book add success");
            }
        }
    }

    private boolean isEmptyCheck() {

        if(bookTitle.getText().isEmpty()){
            bookTitle.requestFocus();
            bookTitle.setFocusColor(Color.RED);
            System.out.println("Book title field is empty");
            return true;
        }
        if(bookAuthor.getText().isEmpty()){
            bookAuthor.requestFocus();
            bookAuthor.setFocusColor(Color.RED);
            System.out.println("Book author field is empty");
            return true;
        }
        if (bookGenre.getText().isEmpty()){
            bookGenre.requestFocus();
            bookGenre.setFocusColor(Color.RED);
            System.out.println("Book genre field is empty");
            return true;
        }
        return false;
    }

    public void btnUpdateBookOnAction(ActionEvent actionEvent) {
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
            String value = (String) availabilityStatus.getValue();
            boolean available;
            if (value.equals("available")){
                available = true;
            }else {
                available=false;
            }

            boolean b = bookBO.updateBook(new BookDto(bookId.getText(), bookTitle.getText(), bookAuthor.getText(),
                    bookGenre.getText(), available));

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

                getAllBooks();
                System.out.println("book update success");
            }
        }
    }
}
