package com.ledger.geektrust.transaction;

import com.ledger.geektrust.dto.BalanceRequestDto;
import com.ledger.geektrust.dto.BalanceResponseDto;
import com.ledger.geektrust.dto.IRequestDto;
import com.ledger.geektrust.service.BalanceService;


public class BalanceTransactionHandler implements ITransaction {

    private final BalanceService balanceService;

    public BalanceTransactionHandler() {
        this.balanceService  = new BalanceService();
    }

    @Override
    public void handleTransaction(IRequestDto request) {
        BalanceResponseDto balance = balanceService.getBalance((BalanceRequestDto) request);
        System.out.println(balance.getBankName() + " " + balance.getBorrowerName() + " " + balance.getAmountPaid() + " " + balance.getNumberOfRemainingEmi());
    }
}
