package com.ledger.geektrust.transaction;

import com.ledger.geektrust.dto.IRequestDto;

public interface ITransaction {
    void handleTransaction(IRequestDto request);
}
