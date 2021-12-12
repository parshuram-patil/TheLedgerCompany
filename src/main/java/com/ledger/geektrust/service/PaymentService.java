package com.ledger.geektrust.service;

import com.ledger.geektrust.dto.PaymentRequestDto;
import com.ledger.geektrust.entity.Loan;
import com.ledger.geektrust.dao.LoanDao;
import com.ledger.geektrust.entity.LoanTransaction;
import com.ledger.geektrust.util.Util;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final LoanDao loanDao;

    PaymentService(LoanDao loanDao) {
        this.loanDao = loanDao;
    }

    public String payEmi(PaymentRequestDto paymentRequestDto) {
        String bankName = paymentRequestDto.getBankName();
        String borrowerName = paymentRequestDto.getBorrowerName();
        Integer emiNumber = paymentRequestDto.getEmiNumber();
        float lumpSumAmount = paymentRequestDto.getLumpSumAmount();

        Loan loan = loanDao.getLoan(borrowerName, bankName);
        int emiAmount = loan.getEmiAmount();

        int amountPaid = Util.cielFloat(lumpSumAmount + emiAmount);
        LoanTransaction transaction = LoanTransaction.builder()
                .bankName(bankName)
                .borrowerName(borrowerName)
                .emiNumber(emiNumber)
                .amountPaid(amountPaid)
                .build();
        loanDao.payEmi(transaction);

        return "Success";
    }
}
