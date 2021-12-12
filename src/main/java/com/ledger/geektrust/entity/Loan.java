package com.ledger.geektrust.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class Loan {
    String bankName;
    String borrowerName;
    String description;
    Float principleAmount;
    Float rateOfInterest;
    Integer tenure;
    Float amount;
    Integer numberOfEmi;
    Integer emiAmount;

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        Loan loan = (Loan) obj;

        return (loan.borrowerName == this.borrowerName && loan.bankName == this.bankName);
    }

    @Override
    public int hashCode()
    {
        return (this.borrowerName + this.bankName).hashCode();
    }
}
