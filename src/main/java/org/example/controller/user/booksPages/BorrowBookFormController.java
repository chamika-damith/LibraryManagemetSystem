package org.example.controller.user.booksPages;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.textfield.TextFields;
import org.example.bo.BOFactory;
import org.example.bo.custom.TransactionBO;
import org.example.controller.user.loginPages.UserLoginFormController;
import org.example.dto.BookDto;
import org.example.dto.TransactionDto;
import org.example.dto.UserDto;
import org.example.dto.usertm.AllBookTm;
import org.example.dto.usertm.BorrowBookTm;
import org.example.entity.Book;
import org.example.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BorrowBookFormController {
    public TableView borrowbookTable;
    public TableColumn colBookId;
    public TableColumn colTitle;
    public TableColumn colAuthor;
    public TableColumn colBorrowDate;
    public TableColumn colReturnDate;
    public TableColumn colReturnBtn;
    public JFXTextField txtSearchBar;


    private ObservableList<BorrowBookTm> obList;

    private TransactionBO transactionBO= (TransactionBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.TRANSACTION);

    public void initialize(){
        setCellValue();
        getAllTransaction();
        //searchTable();
    }

    private void setCellValue() {
        colBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colBorrowDate.setCellValueFactory(new PropertyValueFactory<>("borrowingDate"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        colReturnBtn.setCellValueFactory(new PropertyValueFactory<>("btnreturn"));
    }

    private void getAllTransaction(){
        obList= FXCollections.observableArrayList();
        List<TransactionDto> allTransaction = transactionBO.getTransactions();
        List<String> suggestionList = new ArrayList<>();

        for (TransactionDto dto: allTransaction){
            suggestionList.add(String.valueOf(dto.getTransactionId()));

            Button buttonReturn=createReturnButton();

            obList.add(new BorrowBookTm(
                    dto.getBook().getBookId(),
                    dto.getBook().getTitle(),
                    dto.getBook().getAuthor(),
                    dto.getBorrowingDate(),
                    dto.getReturnDate(),
                    buttonReturn
            ));
        }
        String[] suggestionArray = suggestionList.toArray(new String[0]);
        TextFields.bindAutoCompletion(txtSearchBar, suggestionArray);

        borrowbookTable.setItems(obList);
    }

    public Button createReturnButton(){
        Button btn=new Button("Return");
        btn.getStyleClass().add("removeBtn");
        btn.setCursor(Cursor.cursor("Hand"));
        setReturnBtnAction(btn);
        return btn;
    }

    private void setReturnBtnAction(Button btn) {
        btn.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to return?", yes, no).showAndWait();


            if (type.orElse(no) == yes) {
                BorrowBookTm allBookTm = (BorrowBookTm) borrowbookTable.getSelectionModel().getSelectedItem();

                if (allBookTm != null) {
                    String bookId = allBookTm.getBookId();
                    boolean b = transactionBO.returnBook(bookId);
                    if (b){
                        getAllTransaction();
                    }else {
                        System.out.println("book not return");
                    }
                }
            }
        });
    }
}
