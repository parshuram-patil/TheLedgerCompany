package com.ledger.geektrust.transaction;

import com.ledger.geektrust.dto.IRequestDto;
import com.ledger.geektrust.dto.LoanRequestDto;
import com.ledger.geektrust.service.LoanService;


public class LoanTransactionHandler implements ITransaction{

    private final LoanService loanService;

    public LoanTransactionHandler() {
        loanService = new LoanService();
    }

    @Override
    public void handleTransaction(IRequestDto request) {
            loanService.approveLoan((LoanRequestDto) request);
    }
}
