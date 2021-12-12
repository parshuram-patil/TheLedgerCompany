package com.ledger.geektrust.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoanRequestDto implements IRequestDto {
    String bankName;
    String borrowerName;
    Float principleAmount;
    Integer tenure;
    Float rateOfInterest;
 }
