package com.ledger.geektrust.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PaymentRequestDto implements IRequestDto {
    String bankName;
    String borrowerName;
    Float lumpSumAmount;
    Integer emiNumber;
 }
