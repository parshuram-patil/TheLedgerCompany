package com.ledger.geektrust.handlers;

import com.ledger.geektrust.dto.BalanceRequestDto;
import com.ledger.geektrust.dto.IRequestDto;
import com.ledger.geektrust.dto.LoanRequestDto;
import com.ledger.geektrust.dto.PaymentRequestDto;
import com.ledger.geektrust.transaction.BalanceTransaction;
import com.ledger.geektrust.transaction.LoanTransaction;
import com.ledger.geektrust.transaction.PaymentTransaction;

import java.util.List;


public class TransactionHandler implements ITransactionHandler{

    LoanTransaction loanTransaction;
    PaymentTransaction paymentTransaction;
    BalanceTransaction balanceTransaction;

    public TransactionHandler() {
        loanTransaction = new LoanTransaction();
        paymentTransaction = new PaymentTransaction();
        balanceTransaction = new BalanceTransaction();
    }

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

