package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.TransactionDto;

public interface TransactionBO extends SuperBO {
    boolean saveTransaction(TransactionDto dto);

}
