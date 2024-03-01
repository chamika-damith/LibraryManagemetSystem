package org.example.bo.custom.impl;

import org.example.bo.custom.BookBO;
import org.example.dao.DAOFactory;
import org.example.dao.custom.BookDAO;
import org.example.dto.BookDto;
import org.example.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookBOImpl implements BookBO {

    BookDAO bookDAO= (BookDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOType.BOOK);

    @Override
    public boolean addBook(BookDto dto) {
        return bookDAO.add(new Book(dto.getBookId(),dto.getTitle(),dto.getAuthor(),dto.getGenre(),
                dto.getAvailability()));
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> all = bookDAO.getAll();

        List<BookDto> allBooks = new ArrayList<>();

        for (Book book : all) {
            allBooks.add(new BookDto(book.getBookId(),book.getTitle(),book.getAuthor(),book.getGenre(),
            book.getAvailability()));
        }
        return allBooks;
    }
}
