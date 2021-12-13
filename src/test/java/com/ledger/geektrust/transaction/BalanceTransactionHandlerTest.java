package com.ledger.geektrust.transaction;

import com.ledger.geektrust.dto.BalanceRequestDto;
import com.ledger.geektrust.dto.IRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BalanceTransactionHandlerTest {

    @InjectMocks
    BalanceTransactionHandler balanceTransactionHandler;

    @Test
    void shouldHandleBalanceCheckForFailedTransaction() {
        String bankName = "another_bank";
        String borrowerName = "borrower";
        IRequestDto requestDto = BalanceRequestDto.builder()
                .bankName(bankName)
                .borrowerName(borrowerName)
                .emiNumber(3)
                .build();

        assertThrows(IllegalArgumentException.class, () -> balanceTransactionHandler.handleTransaction(requestDto));
    }
}