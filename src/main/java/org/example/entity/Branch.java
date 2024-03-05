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
public class Branch {
    @Id
    private String branchId;
    private String branchName;
    private String branchLocation;
}
