package org.example.controller.admin.booksPages;

import javafx.scene.control.TableView;

public class BookFormController {
    public TableView bookTable;

    public void initialize(){
        bookTable.getStylesheets().add("/style/style.css");
    }
}
