package com.ledger.geektrust.service;

import com.ledger.geektrust.constant.Constant;
import com.ledger.geektrust.dto.LoanRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class LoanServiceTest {

    @InjectMocks
    LoanService loanService;

    @Test
    void shouldReturnSuccessAfterLoanApproval() {
        LoanRequestDto requestDto = LoanRequestDto.builder()
                .bankName("bank")
                .borrowerName("borrower")
                .principleAmount(5000f)
                .tenure(1)
                .rateOfInterest(6f)
                .build();

        assertEquals(Constant.SUCCESS, loanService.approveLoan(requestDto));
    }

}