package com.ledger.geektrust.transaction;

import com.ledger.geektrust.dto.IRequestDto;
import com.ledger.geektrust.dto.LoanRequestDto;
import com.ledger.geektrust.transaction.LoanTransaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class LoanTransactionTest {

    @InjectMocks
    LoanTransaction loanTransaction;

    @Test
    void shouldHandleLoanTransaction() {
        IRequestDto requestDto = LoanRequestDto.builder()
                .bankName("bank")
                .borrowerName("borrower")
                .principleAmount(5000f)
                .tenure(1)
                .rateOfInterest(6f)
                .build();

        assertDoesNotThrow(() -> loanTransaction.handleTransaction(requestDto));
    }

}