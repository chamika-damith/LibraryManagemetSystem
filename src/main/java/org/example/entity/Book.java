package org.example.entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Book {
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private boolean availability;
}
