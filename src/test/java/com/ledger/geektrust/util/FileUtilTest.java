package com.ledger.geektrust.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {

    @Test
    void shouldReadFileAndCreateRequestDtos() {
        String file = "C:\\Interviews\\geektrust\\src\\main\\resources\\data\\set2.txt";
        assertDoesNotThrow(() -> FileUtil.readTransactions(file));

    }

}