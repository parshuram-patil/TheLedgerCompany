package com.ledger.geektrust.transaction;

import com.ledger.geektrust.dto.IRequestDto;
import com.ledger.geektrust.dto.PaymentRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class PaymentTransactionTest {

    @InjectMocks
    PaymentTransaction paymentTransaction;

    @Test
    void shouldHandlePaymentForFailedTransaction() {
        IRequestDto requestDto = PaymentRequestDto.builder()
                .bankName("bankName")
                .borrowerName("borrowerName")
                .lumpSumAmount(1000f)
                .emiNumber(5)
                .build();

        assertThrows(IllegalArgumentException.class, () -> paymentTransaction.handleTransaction(requestDto));
    }
}