package com.ledger.geektrust.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanTransactionTest {

    @Test
    void shouldEqualIdenticalObjects() {
        LoanTransaction transaction1 = LoanTransaction.builder()
                .bankName("bank")
                .borrowerName("borrower")
                .emiNumber(1)
                .build();
        LoanTransaction transaction2 = LoanTransaction.builder()
                .bankName("bank")
                .borrowerName("borrower")
                .emiNumber(1)
                .build();

        assertTrue(transaction1.equals(transaction1));
        assertTrue(transaction1.equals(transaction2));
    }

    @Test
    void shouldNotEqualNonIdenticalObjects() {
        LoanTransaction transaction1 = LoanTransaction.builder()
                .bankName("bank")
                .borrowerName("borrower")
                .emiNumber(1)
                .build();
        LoanTransaction transaction2 = LoanTransaction.builder()
                .bankName("another_bank")
                .borrowerName("borrower")
                .emiNumber(1)
                .build();

        Loan loan1 = Loan.builder()
                .bankName("bank")
                .borrowerName("borrower")
                .build();

        assertFalse(transaction1.equals(transaction2));
        assertFalse(transaction1.equals(loan1));
    }

    @Test
    void shouldMatchHashOfIdenticalObjects() {
        LoanTransaction transaction1 = LoanTransaction.builder()
                .bankName("bank")
                .borrowerName("borrower")
                .emiNumber(1)
                .build();
        LoanTransaction transaction2 = LoanTransaction.builder()
                .bankName("bank")
                .borrowerName("borrower")
                .emiNumber(1)
                .build();

        assertEquals(transaction1.hashCode(), transaction2.hashCode());
    }

}