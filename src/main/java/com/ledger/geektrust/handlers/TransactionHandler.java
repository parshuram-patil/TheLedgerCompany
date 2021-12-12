package com.ledger.geektrust.handlers;

import com.ledger.geektrust.dto.BalanceRequestDto;
import com.ledger.geektrust.dto.IRequestDto;
import com.ledger.geektrust.dto.LoanRequestDto;
import com.ledger.geektrust.dto.PaymentRequestDto;
import com.ledger.geektrust.transaction.BalanceTransaction;
import com.ledger.geektrust.transaction.ITransaction;
import com.ledger.geektrust.transaction.LoanTransaction;
import com.ledger.geektrust.transaction.PaymentTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionHandler implements ITransactionHandler{

    @Autowired
    LoanTransaction loanTransaction;

    @Autowired
    PaymentTransaction paymentTransaction;

    @Autowired
    BalanceTransaction balanceTransaction;

    @Override
    public void handleTransactions(List<IRequestDto> requests) {
        requests.forEach(e -> {
            if(e instanceof LoanRequestDto )
                loanTransaction.handleTransaction(e);
            else if(e instanceof PaymentRequestDto)
                paymentTransaction.handleTransaction(e);
            else if(e instanceof BalanceRequestDto )
                balanceTransaction.handleTransaction(e);
        });
    }
}

