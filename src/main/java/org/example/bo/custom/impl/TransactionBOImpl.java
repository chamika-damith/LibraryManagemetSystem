package org.example.bo.custom.impl;

import org.example.bo.BOFactory;
import org.example.bo.custom.TransactionBO;
import org.example.dao.DAOFactory;
import org.example.dao.custom.TransactionDAO;
import org.example.dto.TransactionDto;
import org.example.entity.Transaction;

public class TransactionBOImpl implements TransactionBO {

    TransactionDAO transactionDAO= (TransactionDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOType.TRANSACTION);
    @Override
    public boolean saveTransaction(TransactionDto dto) {
        return transactionDAO.add(new Transaction(dto.getTransactionId(),dto.getBorrowingDate(),dto.getReturnDate()
        ,dto.getUser(),dto.getBook()));
    }
}
