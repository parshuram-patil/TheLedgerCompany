package com.ledger.geektrust.handlers;

import com.ledger.geektrust.dto.IRequestDto;
import com.ledger.geektrust.util.FileUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TransactionHandlerTest {

    @InjectMocks
    TransactionHandler transactionHandler;

    @Test
    void shouldProcessAllTransactions() throws IOException {
        String file = "C:\\Interviews\\geektrust\\src\\main\\resources\\data\\set2.txt";
        List<IRequestDto> requestDtos = FileUtil.readTransactions(file);

        assertDoesNotThrow(() -> transactionHandler.handleTransactions(requestDtos));

    }

}