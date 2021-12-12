package com.ledger.geektrust;

import com.ledger.geektrust.dto.IRequestDto;
import com.ledger.geektrust.handlers.TransactionHandler;
import com.ledger.geektrust.util.FileUtil;

import java.io.IOException;
import java.util.List;


public class GeekTrustApplication {


    public static void main(String[] args) throws IOException {
        List<IRequestDto> requestList = FileUtil.readTransactions(args[0]);
        TransactionHandler transactionHandler = new TransactionHandler();
        transactionHandler.handleTransactions(requestList);
    }

}
