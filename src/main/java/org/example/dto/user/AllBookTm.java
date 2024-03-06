package org.example.dto.user;

import javafx.scene.control.Button;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class AllBookTm {
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private String status;
    private Button borrowing;
}
