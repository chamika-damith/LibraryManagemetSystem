package org.example.bo;

import org.example.bo.custom.impl.BookBOImpl;
import org.example.bo.custom.impl.BranchBOImpl;
import org.example.bo.custom.impl.TransactionBOImpl;
import org.example.bo.custom.impl.UserBOImpl;

public class BOFactory {
    public static BOFactory boFactory;

    private BOFactory() {}

    public static BOFactory getBoFactory(){
        return (boFactory==null) ? boFactory=new BOFactory() : boFactory ;
    }

    public enum BOType {
        BOOK,USER,BRANCH,TRANSACTION;
    }

    public SuperBO getBO(BOType boType){
        switch (boType){
            case BOOK :
                return new BookBOImpl();
            case USER:
                return new UserBOImpl();
            case BRANCH:
                return new BranchBOImpl();
            case TRANSACTION:
                return new TransactionBOImpl();
            default:
                return null;
        }
    }
}
