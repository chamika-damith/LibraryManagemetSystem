package org.example.dao;

import java.util.List;

public interface CrudDAO <T> extends SuperDAO{
    boolean add(T dto);
    List<T> getAll();
}
