package org.example.controller.admin.booksPages;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import javafx.scene.paint.Color;
import org.controlsfx.control.textfield.TextFields;
import org.example.bo.BOFactory;
import org.example.bo.custom.BookBO;
import org.example.dto.BookDto;
import org.example.dto.Admintm.BooksTm;
import org.example.entity.Branch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public JFXTextField txtSearchBar;
    public AnchorPane textInputFiealdRoot;

    private BookBO bookBO= (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.BOOK);

    private ObservableList<BooksTm> obList;

    public void initialize(){
        bookTable.getStylesheets().add("/style/style.css");
        setAvailableStatus();
        setCellValue();
        getAllBooks();
        searchTable();
        textInputFiealdRoot.getStyleClass().add("inputField");
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
        List<String> suggestionList = new ArrayList<>();

        for (BookDto dto: allBooks){
            suggestionList.add(String.valueOf(dto.getBookId()));

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
        String[] suggestionArray = suggestionList.toArray(new String[0]);
        TextFields.bindAutoCompletion(txtSearchBar, suggestionArray);

        bookTable.setItems(obList);
    }

    public Button createRemoveButton(){
        Button btn=new Button("Remove");
        btn.getStyleClass().add("removeBtn");
        btn.setCursor(Cursor.cursor("Hand"));
        setDeleteBtnAction(btn);
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


            boolean b = bookBO.addBook(new BookDto(bookId.getText(), bookTitle.getText(), bookAuthor.getText(),
                    bookGenre.getText(), available));

            if (b){
                Image image=new Image("/assest/icon/iconsOk.png");
                try {
                    Notifications notifications=Notifications.create();
                    notifications.graphic(new ImageView(image));
                    notifications.text("Book add success");
                    notifications.title("success");
                    notifications.hideAfter(Duration.seconds(5));
                    notifications.position(Pos.TOP_RIGHT);
                    notifications.show();
                }catch (Exception e){
                    e.printStackTrace();
                }

                getAllBooks();
                clearField();
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
            List<Branch> branches=new ArrayList<>();


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
                clearField();
                System.out.println("book update success");
            }
        }
    }

    private void clearField(){
        bookId.clear();
        bookTitle.clear();
        bookAuthor.clear();
        bookGenre.clear();
    }

    public void searchTable() {
        FilteredList<BooksTm> filteredData = new FilteredList<>(obList, b -> true);

        txtSearchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(booksTm -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                String bookId = String.valueOf(booksTm.getBookId());
                String title = booksTm.getTitle().toLowerCase();
                String genre = booksTm.getGenre().toLowerCase();

                return bookId.contains(lowerCaseFilter) || title.contains(lowerCaseFilter) || genre.contains(lowerCaseFilter);
            });
        });

        SortedList<BooksTm> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(bookTable.comparatorProperty());
        bookTable.setItems(sortedData);
    }

    public void btnSearchBookOnAction(ActionEvent actionEvent) {
        String id = txtSearchBar.getText();

        if (bookBO.isExistBook(id)){
            BookDto bookDto = bookBO.searchBook(id);

            if (bookDto!=null){
                bookId.setText(bookDto.getBookId());
                bookTitle.setText(bookDto.getTitle());
                bookAuthor.setText(bookDto.getAuthor());
                bookGenre.setText(bookDto.getGenre());
                availabilityStatus.setValue(bookDto.isAvailability());

                Image image=new Image("/assest/icon/iconsOk.png");
                try {
                    Notifications notifications=Notifications.create();
                    notifications.graphic(new ImageView(image));
                    notifications.text("Book Search Successfully");
                    notifications.title("Successfully");
                    notifications.hideAfter(Duration.seconds(5));
                    notifications.position(Pos.TOP_RIGHT);
                    notifications.show();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }else {
            System.out.println("no book found");
        }
    }

    private void setDeleteBtnAction(Button btn) {
        btn.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to delete?", yes, no).showAndWait();


            if (type.orElse(no) == yes) {
                int focusedIndex = bookTable.getSelectionModel().getSelectedIndex();
                BooksTm booksTm = (BooksTm) bookTable.getSelectionModel().getSelectedItem();

                if (booksTm != null) {
                    String bookId = booksTm.getBookId();
                    boolean b = bookBO.deleteBook(bookId);
                    if (b) {

                        Image image=new Image("/assest/icon/iconsDelete.png");
                        Notifications notifications=Notifications.create();
                        notifications.graphic(new ImageView(image));
                        notifications.text("Book Delete Successfully");
                        notifications.title("Successfully");
                        notifications.hideAfter(Duration.seconds(5));
                        notifications.position(Pos.TOP_RIGHT);
                        notifications.show();
                        System.out.println("delete selected");
                        obList.remove(focusedIndex);
                        getAllBooks();
                        searchTable();
                    }
                }
            }
        });
    }

}
