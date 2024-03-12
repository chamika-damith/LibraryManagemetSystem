package org.example.controller.user.booksPages;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.textfield.TextFields;
import org.example.bo.BOFactory;
import org.example.bo.custom.TransactionBO;
import org.example.dto.Admintm.BooksTm;
import org.example.dto.BookDto;
import org.example.dto.TransactionDto;
import org.example.dto.usertm.TransactionTm;

import java.util.ArrayList;
import java.util.List;

public class BorrowBookFormController {
    public TableView borrowbookTable;
    public TableColumn colBookId;
    public TableColumn colTitle;
    public TableColumn colAuthor;
    public TableColumn colBorrowDate;
    public TableColumn colReturnDate;
    public TableColumn colReturnBtn;
    public JFXTextField txtSearchBar;


    private ObservableList<TransactionTm> obList;

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

            obList.add(new TransactionTm(
                    dto.getTransactionId(),
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
        //setDeleteBtnAction(btn);
        return btn;
    }

}
