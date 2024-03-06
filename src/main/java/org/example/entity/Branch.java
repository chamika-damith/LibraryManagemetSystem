package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Branch {
    @Id
    private String branchId;

    @Column(nullable = false)
    private String branchName;

    @Column(nullable = false)
    private String branchLocation;

    @ManyToMany(mappedBy = "branch")
    private List<Book> books;
}
