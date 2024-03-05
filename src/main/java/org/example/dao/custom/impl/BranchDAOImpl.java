package org.example.dao.custom.impl;

import org.example.bo.custom.BranchBO;
import org.example.config.FactoryConfiguration;
import org.example.dao.custom.BranchDAO;
import org.example.entity.Branch;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BranchDAOImpl implements BranchDAO {
    @Override
    public boolean add(Branch entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Branch> getAll() {
        return null;
    }

    @Override
    public boolean update(Branch entity) {
        return false;
    }

    @Override
    public boolean isExists(String id) {
        return false;
    }

    @Override
    public Branch search(String id) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
