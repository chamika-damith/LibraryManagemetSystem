package org.example.bo.custom.impl;

import org.example.bo.custom.BookBO;
import org.example.dao.DAOFactory;
import org.example.dao.custom.BookDAO;
import org.example.dto.BookDto;
import org.example.entity.Book;

public class BookBOImpl implements BookBO {

    BookDAO bookDAO= (BookDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOType.BOOK);

    @Override
    public boolean addBook(BookDto dto) {
        return bookDAO.addBook(new Book(dto.getBookId(),dto.getTitle(),dto.getAuthor(),dto.getGenre(),
                dto.isAvailability()));
    }
}
