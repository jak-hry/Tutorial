package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void openLogger(){
        logger = Logger.INSTANCE;
    }

    @Test
    void testGetLastLog() {

        //Given
        //When
        String fileName1 = "log1";
        logger.log(fileName1);
        String fileName2 = "log2";
        logger.log(fileName2);
        String result = logger.getLastLog();

        //Then
        assertEquals(result, fileName2);
    }
}
