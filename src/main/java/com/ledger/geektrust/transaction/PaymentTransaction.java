package com.ledger.geektrust.transaction;

import com.ledger.geektrust.dto.IRequestDto;
import com.ledger.geektrust.dto.LoanRequestDto;
import com.ledger.geektrust.dto.PaymentRequestDto;
import com.ledger.geektrust.service.LoanService;
import com.ledger.geektrust.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentTransaction implements ITransaction {
    @Autowired
    PaymentService paymentService;

    @Override
    public void handleTransaction(IRequestDto request) {
        paymentService.payEmi((PaymentRequestDto) request);
    }
}
