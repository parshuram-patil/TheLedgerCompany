package com.ledger.geektrust.transaction;

import com.ledger.geektrust.dto.IRequestDto;
import com.ledger.geektrust.dto.PaymentRequestDto;
import com.ledger.geektrust.service.PaymentService;

public class PaymentTransaction implements ITransaction {

    private final PaymentService paymentService;

    public PaymentTransaction() {
        paymentService = new PaymentService();
    }

    @Override
    public void handleTransaction(IRequestDto request) {
        paymentService.payEmi((PaymentRequestDto) request);
    }
}
