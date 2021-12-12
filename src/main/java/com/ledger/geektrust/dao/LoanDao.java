package com.ledger.geektrust.dao;

import com.ledger.geektrust.entity.Loan;
import com.ledger.geektrust.entity.LoanTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class LoanDao {
    private static List<Loan> loans = new ArrayList<>();
    private static List<LoanTransaction> transactions = new ArrayList<>();

    public static Loan getLoan(String borrowerName, String bankName) throws IllegalArgumentException {
        Optional<Loan> result = loans.stream()
                .filter(loan -> loan.getBorrowerName().equals(borrowerName) && loan.getBankName().equals(bankName))
                .findFirst();
        if (!result.isPresent())
            throw new IllegalArgumentException("Customer Not Found");

        return result.get();
    }

    public static Loan createLoan(Loan loan) {
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
            payEmi(transaction);
        }

        loans.add(loan);

        return loan;
    }

    public static void payEmi(LoanTransaction transaction) throws IllegalArgumentException {
        int index = transactions.indexOf(transaction);
        if (index < 0)
            transactions.add(transaction);
        else
            transactions.set(index, transaction);
    }

    public static List<LoanTransaction> getTransactions(String customerName, String bankName, Integer emiNumber) {

        return transactions.stream()
                .filter(transaction -> (
                                transaction.getBorrowerName().equals(customerName) &&
                                        transaction.getBankName().equals(bankName) &&
                                        transaction.getEmiNumber() <= emiNumber
                        )
                )
                .collect(Collectors.toList());
    }
}
