package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
//@AllArgsConstructor
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

//    @ManyToOne
//    @JoinColumn(name="book" , nullable = false)
//    private Book book;

    public Branch(String branchId, String branchName, String branchLocation) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.branchLocation = branchLocation;
    }
}
