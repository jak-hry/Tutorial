package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

class CollectionTestSuite {

    private static OddNumbersExterminator oddNumbersExterminator;

    @BeforeEach
    public void beforeEach() {
        System.out.println("Test case: begin");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Test case: end");
    }

    @BeforeAll
    public static void beforeClass() {
        oddNumbersExterminator = new OddNumbersExterminator();
    }

    @DisplayName("Checking if the class behaves correctly, when the list is empty,")

    @Test
    void testOddNumbersExterminatorEmptyList() {

        //Given
        List<Integer> emptyList = new ArrayList<>();

        //When
        List<Integer> newEmptyList = oddNumbersExterminator.exterminate(emptyList);
        System.out.println("Testing empty list");

        //Then
        Assertions.assertEquals(emptyList, newEmptyList);

    }

    @DisplayName("checking if the class behaves correctly, when the list contains even and odd numbers")

    @Test
    void testOddNumbersExterminatorNormalList() {

        //Given
        List<Integer> normalList = new ArrayList<>();
        normalList.add(1);
        normalList.add(3);
        normalList.add(5);
        normalList.add(7);
        normalList.add(9);

        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(0);
        expectedList.add(2);
        expectedList.add(4);
        expectedList.add(6);
        expectedList.add(8);

        //When
        List<Integer> resultList = oddNumbersExterminator.exterminate(normalList);
        System.out.println("Testing odd numbers list");

        //Then
        Assertions.assertNotEquals(expectedList, resultList);

    }

}