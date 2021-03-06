package com.ledger.geektrust.service;

import com.ledger.geektrust.constant.Constant;
import com.ledger.geektrust.dao.LoanDao;
import com.ledger.geektrust.dto.PaymentRequestDto;
import com.ledger.geektrust.entity.Loan;
import com.ledger.geektrust.entity.LoanTransaction;
import com.ledger.geektrust.util.Util;


public class PaymentService {

    public String payEmi(PaymentRequestDto paymentRequestDto) {
        String bankName = paymentRequestDto.getBankName();
        String borrowerName = paymentRequestDto.getBorrowerName();
        Integer emiNumber = paymentRequestDto.getEmiNumber();
        float lumpSumAmount = paymentRequestDto.getLumpSumAmount();

        Loan loan = LoanDao.getLoan(borrowerName, bankName);
        int emiAmount = emiNumber == 0 ? 0 : loan.getEmiAmount();

        int amountPaid = Util.cielFloat(lumpSumAmount + emiAmount);
        //amountPaid = emiNumber == 0 ? -1 * amountPaid : amountPaid;
        LoanTransaction transaction = LoanTransaction.builder()
                .bankName(bankName)
                .borrowerName(borrowerName)
                .emiNumber(emiNumber)
                .amountPaid(amountPaid)
                .build();
        LoanDao.payEmi(transaction);

        return Constant.SUCCESS;
    }
}
