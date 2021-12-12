package com.ledger.geektrust;

import com.ledger.geektrust.dto.BalanceRequestDto;
import com.ledger.geektrust.dto.IRequestDto;
import com.ledger.geektrust.dto.LoanRequestDto;
import com.ledger.geektrust.dto.PaymentRequestDto;
import com.ledger.geektrust.handlers.TransactionHandler;

import java.util.ArrayList;
import java.util.List;


public class GeekTrustApplication {


	public static void main(String[] args) {


		TransactionHandler transactionHandler = new TransactionHandler();

		List<IRequestDto> requestList = new ArrayList<>();
		LoanRequestDto loan = LoanRequestDto.builder()
				.bankName("A")
				.borrowerName("P")
				.principleAmount(5000f)
				.tenure(1)
				.rateOfInterest(6f)
				.build();

		PaymentRequestDto payment = PaymentRequestDto.builder()
				.bankName("A")
				.borrowerName("P")
				.lumpSumAmount(1000f)
				.emiNumber(5)
				.build();

		BalanceRequestDto balance1 = BalanceRequestDto.builder()
				.bankName("A")
				.borrowerName("P")
				.emiNumber(3)
				.build();

		BalanceRequestDto balance2 = BalanceRequestDto.builder()
				.bankName("A")
				.borrowerName("P")
				.emiNumber(6)
				.build();

		requestList.add(loan);
		requestList.add(payment);
		requestList.add(balance1);
		requestList.add(balance2);

		transactionHandler.handleTransactions(requestList);
	}

}
