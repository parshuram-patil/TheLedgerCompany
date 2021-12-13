package com.ledger.geektrust.service;

import com.ledger.geektrust.constant.Constant;
import com.ledger.geektrust.dao.LoanDao;
import com.ledger.geektrust.dto.LoanRequestDto;
import com.ledger.geektrust.dto.PaymentRequestDto;
import com.ledger.geektrust.entity.Loan;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @InjectMocks
    PaymentService paymentService;

    @InjectMocks
    LoanService loanService;

    @Test
    void shouldReturnSuccessAfterPayment() {

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

        assertEquals(Constant.SUCCESS, paymentService.payEmi(payment));
    }

    @Test
    void shouldReturnSuccessAfterDownPayment() {

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
                .emiNumber(0)
                .build();

        assertEquals(Constant.SUCCESS, paymentService.payEmi(payment));
    }

    @Test
    void shouldThrowExceptionIfCustomerNotFound() {

        String bankName = "another_bank";
        String borrowerName = "borrower";

        PaymentRequestDto payment = PaymentRequestDto.builder()
                .bankName(bankName)
                .borrowerName(borrowerName)
                .lumpSumAmount(1000f)
                .emiNumber(5)
                .build();

        assertThrows(IllegalArgumentException.class, () -> paymentService.payEmi(payment));
    }

}