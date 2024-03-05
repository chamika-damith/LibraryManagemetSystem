package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter


@Entity
public class User {
    @Id
    private String userId;
    private String userName;
    private String email;
    private String password;
}
