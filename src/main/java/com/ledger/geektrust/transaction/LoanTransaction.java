package com.ledger.geektrust.transaction;

import com.ledger.geektrust.dto.IRequestDto;
import com.ledger.geektrust.dto.LoanRequestDto;
import com.ledger.geektrust.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanTransaction implements ITransaction{

    @Autowired
    LoanService loanService;

    @Override
    public void handleTransaction(IRequestDto request) {
        loanService.approveLoan((LoanRequestDto) request);
    }
}
