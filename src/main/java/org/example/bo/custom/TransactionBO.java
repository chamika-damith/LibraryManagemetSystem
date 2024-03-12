package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.TransactionDto;

import java.util.List;

public interface TransactionBO extends SuperBO {
    boolean saveTransaction(TransactionDto dto);

    List<TransactionDto> getTransactions();

}
