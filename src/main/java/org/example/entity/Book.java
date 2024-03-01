package org.example.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Book {
    @Id
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private String availability;
}
