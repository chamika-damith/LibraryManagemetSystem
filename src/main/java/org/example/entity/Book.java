package org.example.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Book {
    @Id
    private String bookId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private boolean availability;

    @OneToMany(mappedBy = "book")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "book")
    private List<Branch> branches;

    public Book(String bookId, String title, String author, String genre, boolean availability) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = availability;
    }
}
