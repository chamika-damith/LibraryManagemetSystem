package org.example.controller.user.booksPages;

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
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.TextFields;
import org.example.bo.BOFactory;
import org.example.bo.custom.BookBO;
import org.example.dto.BookDto;
import org.example.dto.tm.BooksTm;
import org.example.dto.user.AllBookTm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AllBookFromController {
    public TableView bookTable;
    public TableColumn colBookId;
    public TableColumn colTitle;
    public TableColumn colAuthor;
    public TableColumn colGenre;
    public TableColumn colStatus;
    public TableColumn colBorrowing;
    public JFXTextField txtSearchBar;

    private BookBO bookBO= (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.BOOK);

    private ObservableList<AllBookTm> obList;


    public void initialize(){
        bookTable.getStylesheets().add("/style/style.css");
        setCellValue();
        getAllBooks();
        //searchTable();
    }

    private void setCellValue() {
        colBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colBorrowing.setCellValueFactory(new PropertyValueFactory<>("borrowing"));
    }

    private void getAllBooks(){
        obList= FXCollections.observableArrayList();
        List<BookDto> allBooks = bookBO.getAllBooks();
        List<String> suggestionList = new ArrayList<>();

        for (BookDto dto: allBooks){
            suggestionList.add(String.valueOf(dto.getBookId()));

            Button buttonBorrow=createBorrowButton();
            String available;
            if (dto.isAvailability()){
                available="available";
            }else{
                available="notAvailable";
            }

            obList.add(new AllBookTm(
                    dto.getBookId(),
                    dto.getTitle(),
                    dto.getAuthor(),
                    dto.getGenre(),
                    available,
                    buttonBorrow
            ));
        }
        String[] suggestionArray = suggestionList.toArray(new String[0]);
        TextFields.bindAutoCompletion(txtSearchBar, suggestionArray);

        bookTable.setItems(obList);
    }

    public Button createBorrowButton(){
        Button btn=new Button("Borrow");
        btn.getStyleClass().add("BorrowBtn");
        btn.setCursor(Cursor.cursor("Hand"));
        setBorrowBtnAction(btn);
        return btn;
    }

    private void setBorrowBtnAction(Button btn) {
        btn.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to borrow?", yes, no).showAndWait();


            if (type.orElse(no) == yes) {
                int focusedIndex = bookTable.getSelectionModel().getSelectedIndex();
                AllBookTm allBookTm = (AllBookTm) bookTable.getSelectionModel().getSelectedItem();

                if (allBookTm != null) {
                    String bookId = allBookTm.getBookId();

                }
            }
        });
    }
}
