package com.ledger.geektrust.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BalanceResponseDto {
    String bankName;
    String borrowerName;
    Integer amountPaid;
    Integer numberOfRemainingEmi;
 }
