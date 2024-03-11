package org.example.bo.custom.impl;

import org.example.bo.custom.TransactionBO;
import org.example.dto.TransactionDto;

public class TransactionBOImpl implements TransactionBO {
    @Override
    public boolean saveTransaction(TransactionDto dto) {
        return false;
    }
}
