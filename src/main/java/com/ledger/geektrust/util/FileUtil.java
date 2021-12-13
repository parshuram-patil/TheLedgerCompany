package com.ledger.geektrust.util;

import com.ledger.geektrust.constant.Constant;
import com.ledger.geektrust.dto.BalanceRequestDto;
import com.ledger.geektrust.dto.IRequestDto;
import com.ledger.geektrust.dto.LoanRequestDto;
import com.ledger.geektrust.dto.PaymentRequestDto;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class FileUtil {
    public static List<IRequestDto> readTransactions(String filePath) throws IOException {
        List<IRequestDto> requestDtos = new ArrayList<>();
        File file = new File(filePath);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] tokens = line.split(" ");
            if(tokens[0].equals(Constant.TRANSACTION_LOAN)) {
                requestDtos.add(getLoanRequestDto(tokens));
            }
            else if(tokens[0].equals(Constant.TRANSACTION_PAYMENT)) {
                requestDtos.add(getPaymentRequestDto(tokens));
            }
            else if(tokens[0].equals(Constant.TRANSACTION_BALANCE)) {
                requestDtos.add(getBalanceRequestDto(tokens));
            }
        }
        fr.close();

        return requestDtos;
    }

    private static IRequestDto getBalanceRequestDto(String[] tokens) {
        return BalanceRequestDto.builder()
                .bankName(tokens[1])
                .borrowerName(tokens[2])
                .emiNumber(Integer.valueOf(tokens[3]))
                .build();
    }

    private static IRequestDto getPaymentRequestDto(String[] tokens) {
        return PaymentRequestDto.builder()
                .bankName(tokens[1])
                .borrowerName(tokens[2])
                .lumpSumAmount(Float.valueOf(tokens[3]))
                .emiNumber(Integer.valueOf(tokens[4]))
                .build();
    }

    private static IRequestDto getLoanRequestDto(String[] tokens) {
        return LoanRequestDto.builder()
                .bankName(tokens[1])
                .borrowerName(tokens[2])
                .principleAmount(Float.valueOf(tokens[3]))
                .tenure(Integer.valueOf(tokens[4]))
                .rateOfInterest(Float.valueOf(tokens[5]))
                .build();
    }
}
