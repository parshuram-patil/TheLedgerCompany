package com.ledger.geektrust.transaction;

import com.ledger.geektrust.dto.IRequestDto;
import com.ledger.geektrust.dto.PaymentRequestDto;
import com.ledger.geektrust.service.PaymentService;

public class PaymentTransactionHandler implements ITransaction {

    private final PaymentService paymentService;

    public PaymentTransactionHandler() {
        paymentService = new PaymentService();
    }

    @Override
    public void handleTransaction(IRequestDto request) {
        paymentService.payEmi((PaymentRequestDto) request);
    }
}
