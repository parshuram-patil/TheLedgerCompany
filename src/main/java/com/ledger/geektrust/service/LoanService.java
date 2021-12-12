package com.ledger.geektrust.service;

import com.ledger.geektrust.dao.LoanDao;
import com.ledger.geektrust.dto.LoanRequestDto;
import com.ledger.geektrust.entity.Loan;
import com.ledger.geektrust.util.Util;


public class LoanService {

    public String approveLoan(LoanRequestDto loanDto) {
        Float principleAmount = loanDto.getPrincipleAmount();
        Float rateOfInterest = loanDto.getRateOfInterest();
        Integer tenure = loanDto.getTenure();
        Float interest = (principleAmount * rateOfInterest * tenure) / 100;
        Float loanAmount = principleAmount + interest;
        Integer noOfEmi = tenure * 12;
        int emiAmount = Util.cielFloat(loanAmount/noOfEmi);

        Loan loan = Loan.builder()
                .bankName(loanDto.getBankName())
                .borrowerName(loanDto.getBorrowerName())
                .principleAmount(principleAmount)
                .rateOfInterest(rateOfInterest)
                .tenure(tenure)
                .amount(loanAmount)
                .numberOfEmi(noOfEmi)
                .emiAmount(Util.cielFloat(emiAmount))
                .build();
        LoanDao.createLoan(loan);

        return "Success";
    }
}
