package org.example.dao.custom.impl;

import org.example.bo.custom.BookBO;
import org.example.config.FactoryConfiguration;
import org.example.dao.custom.BookDAO;
import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BookDAOImpl implements BookDAO {
    @Override
    public boolean add(Book dto) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        session.save(dto);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Book> getAll() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        Query<Book> query = session.createQuery("FROM Book", Book.class);
        List<Book> resultList = query.getResultList();

        transaction.commit();
        session.close();
        return resultList;
    }

    @Override
    public boolean update(Book dto) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        session.update(dto);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean isExists(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Book book= session.get(Book.class,id);
        transaction.commit();
        session.close();

        return book != null;
    }

    @Override
    public Book search(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Book> query = session.createQuery("FROM Book WHERE bookId=:id",Book.class);
        query.setParameter("id",id);

        Book book = query.getSingleResult();

        transaction.commit();
        session.close();

        return book;
    }

    @Override
    public boolean delete(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Book book = session.get(Book.class, id);

        if (book!=null){
            session.delete(book);
            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }
}
