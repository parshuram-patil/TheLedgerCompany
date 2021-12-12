package com.ledger.geektrust.service;

import com.ledger.geektrust.dao.LoanDao;
import com.ledger.geektrust.dto.BalanceRequestDto;
import com.ledger.geektrust.dto.BalanceResponseDto;
import com.ledger.geektrust.entity.Loan;
import com.ledger.geektrust.entity.LoanTransaction;
import com.ledger.geektrust.util.Util;

import java.util.List;


public class BalanceService {

    public BalanceResponseDto getBalance(BalanceRequestDto request) {
        String borrowerName = request.getBorrowerName();
        String bankName = request.getBankName();
        Integer emiNumber = request.getEmiNumber();
        List<LoanTransaction> transactions = LoanDao.getTransactions(
                borrowerName,
                bankName,
                emiNumber
        );
        int paidLoanAmount = Util.cielDouble(
                transactions.stream()
                .mapToDouble(LoanTransaction::getAmountPaid)
                .sum()
        );

        Loan loan = LoanDao.getLoan(borrowerName, bankName);
        Float loanAmount = loan.getAmount();
        Integer emiAmount = loan.getEmiAmount();
        int numberOfRemainingEmi = Util.cielDouble((loanAmount - paidLoanAmount)/ emiAmount);

        return BalanceResponseDto.builder()
                .bankName(bankName)
                .borrowerName(borrowerName)
                .amountPaid(paidLoanAmount)
                .numberOfRemainingEmi(numberOfRemainingEmi)
                .build();
    }
}
