package org.example.dao;

import org.example.dao.custom.impl.*;

public class DAOFactory {
    public static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)? daoFactory=new DAOFactory() : daoFactory;
    }

    public enum DAOType {
        BOOK,USER,BRANCH,TRANSACTION,LOGIN;
    }

    public SuperDAO getDao(DAOType daoType){
        switch (daoType){
            case BOOK :
                return new BookDAOImpl();
            case USER:
                return new UserDAOImpl();
            case BRANCH:
                return new BranchDAOImpl();
            case TRANSACTION:
                return new TransactionDAOImpl();
            case LOGIN:
                new UserLoginDAOImpl();
            default:
                return null;
        }
    }
}
