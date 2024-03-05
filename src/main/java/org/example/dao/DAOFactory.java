package org.example.dao;

import org.example.dao.custom.impl.BookDAOImpl;
import org.example.dao.custom.impl.BranchDAOImpl;
import org.example.dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    public static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)? daoFactory=new DAOFactory() : daoFactory;
    }

    public enum DAOType {
        BOOK,USER,BRANCH;
    }

    public SuperDAO getDao(DAOType daoType){
        switch (daoType){
            case BOOK :
                return new BookDAOImpl();
            case USER:
                return new UserDAOImpl();
            case BRANCH:
                return new BranchDAOImpl();
            default:
                return null;
        }
    }
}
