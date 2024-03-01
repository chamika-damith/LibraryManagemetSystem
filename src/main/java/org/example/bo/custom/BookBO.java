package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.BookDto;

public interface BookBO extends SuperBO {
    boolean addBook(BookDto dto);
}
