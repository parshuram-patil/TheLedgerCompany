package com.ledger.geektrust.dao;

import com.ledger.geektrust.entity.Loan;
import com.ledger.geektrust.entity.LoanTransaction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LoanDao {
    private List<Loan> loans = new ArrayList<>();
    private List<LoanTransaction> transactions = new ArrayList<>();

    public Loan getLoan(String borrowerName, String bankName) throws IllegalArgumentException {
        Optional<Loan> result = loans.stream()
                .filter(loan -> loan.getBorrowerName().equals(borrowerName) && loan.getBankName().equals(bankName))
                .findFirst();
        if (!result.isPresent())
            throw new IllegalArgumentException("Customer Not Found");

        return result.get();
    }

    public Loan createLoan(Loan loan) {
        /*
            This is just representation of actual EMI paid by borrower
            Eg. SI(Auto debit), 3rd party deposit, manual deposits, etc.
        */

        for (int emiNumber = 1; emiNumber <= loan.getNumberOfEmi(); emiNumber++) {
            LoanTransaction transaction = LoanTransaction.builder()
                    .bankName(loan.getBankName())
                    .borrowerName(loan.getBorrowerName())
                    .emiNumber(emiNumber)
                    .amountPaid(loan.getEmiAmount())
                    .build();
            this.payEmi(transaction);
        }

        this.loans.add(loan);

        return loan;
    }

    public void payEmi(LoanTransaction transaction) throws IllegalArgumentException {
        int index = this.transactions.indexOf(transaction);
        if (index < 0)
            this.transactions.add(transaction);
        else
            this.transactions.set(index, transaction);
    }

    public List<LoanTransaction> getTransactions(String customerName, String bankName, Integer emiNumber) {

        return this.transactions.stream()
                .filter(transaction -> (
                                transaction.getBorrowerName().equals(customerName) &&
                                        transaction.getBankName().equals(bankName) &&
                                        transaction.getEmiNumber() <= emiNumber
                        )
                )
                .collect(Collectors.toList());
    }
}
