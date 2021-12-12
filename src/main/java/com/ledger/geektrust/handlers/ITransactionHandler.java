package com.ledger.geektrust.handlers;

import com.ledger.geektrust.dto.IRequestDto;

import java.util.List;

public interface ITransactionHandler {
    void handleTransactions(List<IRequestDto> requests);
}

