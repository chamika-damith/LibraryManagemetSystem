package org.example.dao;

import org.example.dao.custom.impl.BookDAOImpl;

public class DAOFactory {
    public static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)? daoFactory=new DAOFactory() : daoFactory;
    }

    public enum DAOType {
        BOOK;
    }

    public SuperDAO getDao(DAOType daoType){
        switch (daoType){
            case BOOK :
                return new BookDAOImpl();
            default:
                return null;
        }
    }
}
