package com.ledger.geektrust.entity;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class LoanTransaction {
    String bankName;
    String borrowerName;
    Integer emiNumber;
    Integer amountPaid;

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        LoanTransaction transaction = (LoanTransaction) obj;

        return (
                transaction.borrowerName.equals(this.borrowerName) &&
                        transaction.bankName.equals(this.bankName) &&
                        transaction.getEmiNumber().equals(this.getEmiNumber())
        );
    }

    @Override
    public int hashCode()
    {
        return (this.borrowerName + this.bankName + String.valueOf(this.getEmiNumber())).hashCode();
    }
}
