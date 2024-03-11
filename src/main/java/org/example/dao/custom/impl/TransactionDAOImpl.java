package org.example.dao.custom.impl;

import org.example.config.FactoryConfiguration;
import org.example.dao.custom.TransactionDAO;
import org.example.entity.Transaction;
import org.hibernate.Session;

import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {
    @Override
    public boolean add(Transaction entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        org.hibernate.Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Transaction> getAll() {
        return null;
    }

    @Override
    public boolean update(Transaction entity) {
        return false;
    }

    @Override
    public boolean isExists(String id) {
        return false;
    }

    @Override
    public Transaction search(String id) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
