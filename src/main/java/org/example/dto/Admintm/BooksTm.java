package org.example.dto.Admintm;

import lombok.*;

import javafx.scene.control.Button;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class BooksTm {
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private Button availability;
    private Button remove;
}
