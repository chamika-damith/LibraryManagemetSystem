package org.example.dao.custom.impl;

import org.example.bo.custom.BranchBO;
import org.example.config.FactoryConfiguration;
import org.example.dao.custom.BranchDAO;
import org.example.entity.Branch;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean isExists(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Branch branch= session.get(Branch.class,id);
        transaction.commit();
        session.close();

        return branch != null;
    }

    @Override
    public Branch search(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Branch> query = session.createQuery("FROM Branch WHERE branchId=:id",Branch.class);
        query.setParameter("id",id);

        Branch branch = query.getSingleResult();

        transaction.commit();
        session.close();

        return branch;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
