package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.BookDto;

import java.util.List;

public interface BookBO extends SuperBO {
    boolean addBook(BookDto dto);
    List<BookDto> getAllBooks();
    boolean updateBook(BookDto dto);
}
