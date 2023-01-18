package com.kodilla.patterns.singleton;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        String fileName = "logger";
        logger.log(fileName);
        String result = logger.getLastLog();

        //Then
        assertEquals(result, fileName);
    }
}
