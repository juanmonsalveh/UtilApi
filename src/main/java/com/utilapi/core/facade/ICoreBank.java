package com.utilapi.core.facade;


import com.utilapi.core.dto.TransactionDTO;

import java.util.List;

public interface ICoreBank {
    boolean generateAccount (int sharedkey);
    List<TransactionDTO> retrieveTransactions();
    List<TransactionDTO> retrieveTransactions(String username);
    boolean validateTransactionOtp(String otp, String sharedKey);
    TransactionDTO createTransactionDto(TransactionDTO transactionDTO);
}
