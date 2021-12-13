package com.ledger.geektrust.handlers;

import com.ledger.geektrust.dto.BalanceRequestDto;
import com.ledger.geektrust.dto.IRequestDto;
import com.ledger.geektrust.dto.LoanRequestDto;
import com.ledger.geektrust.dto.PaymentRequestDto;
import com.ledger.geektrust.transaction.BalanceTransactionHandler;
import com.ledger.geektrust.transaction.LoanTransactionHandler;
import com.ledger.geektrust.transaction.PaymentTransactionHandler;

import java.util.List;


public class TransactionHandler implements ITransactionHandler{

    LoanTransactionHandler loanTransactionHandler;
    PaymentTransactionHandler paymentTransactionHandler;
    BalanceTransactionHandler balanceTransactionHandler;

    public TransactionHandler() {
        loanTransactionHandler = new LoanTransactionHandler();
        paymentTransactionHandler = new PaymentTransactionHandler();
        balanceTransactionHandler = new BalanceTransactionHandler();
    }

    @Override
    public void handleTransactions(List<IRequestDto> requests) {
        requests.forEach(e -> {
            if(e instanceof LoanRequestDto )
                loanTransactionHandler.handleTransaction(e);
            else if(e instanceof PaymentRequestDto)
                paymentTransactionHandler.handleTransaction(e);
            else if(e instanceof BalanceRequestDto )
                balanceTransactionHandler.handleTransaction(e);
        });
    }
}

