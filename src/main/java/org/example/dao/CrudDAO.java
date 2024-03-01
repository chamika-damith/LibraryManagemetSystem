package org.example.dao;

public interface CrudDAO <T> extends SuperDAO{
    boolean addBook(T dto);
}
