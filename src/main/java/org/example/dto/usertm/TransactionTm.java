package org.example.dto.usertm;

import javafx.scene.control.Button;
import lombok.*;
import org.example.entity.Book;
import org.example.entity.User;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class TransactionTm {
    private String transactionId;
    private Date borrowingDate;
    private Date returnDate;
    private User user;
    private Book book;
    private Button btnreturn;
}
