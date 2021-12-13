package com.ledger.geektrust.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {

    @Test
    void shouldStoreUniqueLoanObjets() {
        Loan loan1 = Loan.builder()
                .bankName("bank")
                .borrowerName("borrower")
                .build();
        List<Loan> loans = Arrays.asList(loan1);
        int index = loans.indexOf(loan1);
        Loan loan2 = Loan.builder()
                .bankName("bank")
                .borrowerName("borrower")
                .build();
        loans.set(index, loan2);

        assertEquals(1, loans.size());
    }

    @Test
    void shouldEqualIdenticalObjects() {
        Loan loan1 = Loan.builder()
                .bankName("bank")
                .borrowerName("borrower")
                .build();
        Loan loan2 = Loan.builder()
                .bankName("bank")
                .borrowerName("borrower")
                .build();

        assertTrue(loan1.equals(loan1));
        assertTrue(loan1.equals(loan2));
    }



    @Test
    void shouldNotEqualNonIdenticalObjects() {
        Loan loan1 = Loan.builder()
                .bankName("another_bank")
                .borrowerName("borrower")
                .build();
        Loan loan2 = Loan.builder()
                .bankName("bank")
                .borrowerName("borrower")
                .build();
        LoanTransaction transaction1 = LoanTransaction.builder()
                .bankName("bank")
                .borrowerName("borrower")
                .emiNumber(1)
                .build();

        assertFalse(loan1.equals(loan2));
        assertFalse(loan1.equals(transaction1));
    }

    @Test
    void shouldMatchHashOfIdenticalObjects() {
        Loan loan1 = Loan.builder()
                .bankName("bank")
                .borrowerName("borrower")
                .build();
        Loan loan2 = Loan.builder()
                .bankName("bank")
                .borrowerName("borrower")
                .build();

        assertEquals(loan1.hashCode(), loan2.hashCode());
    }

}