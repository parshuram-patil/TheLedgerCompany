package com.ledger.geektrust.service;

import com.ledger.geektrust.constant.Constant;
import com.ledger.geektrust.dto.BalanceRequestDto;
import com.ledger.geektrust.dto.BalanceResponseDto;
import com.ledger.geektrust.dto.LoanRequestDto;
import com.ledger.geektrust.dto.PaymentRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BalanceServiceTest {

    @InjectMocks
    BalanceService balanceService;

    @InjectMocks
    PaymentService paymentService;

    @InjectMocks
    LoanService loanService;

    @Test
    void shouldReturnSuccessAfterBalanceCheck() {

        String bankName = "bank";
        String borrowerName = "borrower";
        LoanRequestDto requestDto = LoanRequestDto.builder()
                .bankName("bank")
                .borrowerName("borrower")
                .principleAmount(5000f)
                .tenure(1)
                .rateOfInterest(6f)
                .build();
        loanService.approveLoan(requestDto);
        PaymentRequestDto payment = PaymentRequestDto.builder()
                .bankName(bankName)
                .borrowerName(borrowerName)
                .lumpSumAmount(1000f)
                .emiNumber(5)
                .build();
        paymentService.payEmi(payment);

        BalanceRequestDto balance = BalanceRequestDto.builder()
                .bankName(bankName)
                .borrowerName(borrowerName)
                .emiNumber(3)
                .build();
        BalanceResponseDto responseDto = BalanceResponseDto.builder()
                .bankName(bankName)
                .borrowerName(borrowerName)
                .numberOfRemainingEmi(9)
                .amountPaid(1326)
                .build();

        assertEquals(responseDto.getNumberOfRemainingEmi(), balanceService.getBalance(balance).getNumberOfRemainingEmi());
    }

}