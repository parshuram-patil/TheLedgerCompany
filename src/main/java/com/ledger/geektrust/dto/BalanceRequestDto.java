package com.ledger.geektrust.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BalanceRequestDto implements IRequestDto {
    String bankName;
    String borrowerName;
    Integer emiNumber;
 }
