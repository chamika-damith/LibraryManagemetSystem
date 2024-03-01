package org.example.dto.tm;

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
    private String availability;
    private Button update;
    private Button remove;
}
