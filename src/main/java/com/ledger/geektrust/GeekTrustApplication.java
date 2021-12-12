package com.ledger.geektrust;

import com.ledger.geektrust.dto.BalanceRequestDto;
import com.ledger.geektrust.dto.IRequestDto;
import com.ledger.geektrust.dto.LoanRequestDto;
import com.ledger.geektrust.dto.PaymentRequestDto;
import com.ledger.geektrust.entity.Loan;
import com.ledger.geektrust.handlers.TransactionHandler;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
public class GeekTrustApplication {


	public static void main(String[] args) {

		//ConfigurableApplicationContext app = SpringApplication.run(GeekTrustApplication .class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GeekTrustApplication.class);
		TransactionHandler transactionHandler = context.getBean(TransactionHandler.class);

		List<IRequestDto> requestList = new ArrayList<>();
		LoanRequestDto loan = LoanRequestDto.builder()
				.bankName("A")
				.borrowerName("P")
				.principleAmount(10000f)
				.tenure(3)
				.rateOfInterest(7f)
				.build();

		PaymentRequestDto payment = PaymentRequestDto.builder()
				.bankName("A")
				.borrowerName("P")
				.lumpSumAmount(5000f)
				.emiNumber(10)
				.build();

		BalanceRequestDto balance1 = BalanceRequestDto.builder()
				.bankName("A")
				.borrowerName("P")
				.emiNumber(12)
				.build();

		BalanceRequestDto balance2 = BalanceRequestDto.builder()
				.bankName("A")
				.borrowerName("P")
				.emiNumber(6)
				.build();

		requestList.add(loan);
		requestList.add(payment);
		requestList.add(balance1);
		//requestList.add(balance2);

		transactionHandler.handleTransactions(requestList);
		context.close();
	}

}
