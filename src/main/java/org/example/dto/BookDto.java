package org.example.dto;
import lombok.*;
import org.example.entity.Branch;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class BookDto {
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private boolean availability;
//    private List<Branch> branch;
}
