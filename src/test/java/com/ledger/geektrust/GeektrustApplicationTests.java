package com.ledger.geektrust;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GeekTrustApplicationTests {

    @Test
    void shouldRunApplication() {
        String file = "C:\\Interviews\\geektrust\\src\\main\\resources\\data\\set2.txt";

        assertDoesNotThrow(() -> GeekTrustApplication.main(new String[]{file}));
    }

}
