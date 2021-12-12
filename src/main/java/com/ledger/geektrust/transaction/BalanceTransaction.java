package com.ledger.geektrust.transaction;

import com.ledger.geektrust.dto.BalanceRequestDto;
import com.ledger.geektrust.dto.BalanceResponseDto;
import com.ledger.geektrust.dto.IRequestDto;
import com.ledger.geektrust.dto.PaymentRequestDto;
import com.ledger.geektrust.service.BalanceService;
import com.ledger.geektrust.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BalanceTransaction implements ITransaction {
    @Autowired
    BalanceService balanceService;

    @Override
    public void handleTransaction(IRequestDto request) {
        BalanceResponseDto balance = balanceService.getBalance((BalanceRequestDto) request);
        System.out.println(balance.getBankName() + " " + balance.getBorrowerName() + " " + balance.getAmountPaid() + " " + balance.getNumberOfRemainingEmi());
    }
}
