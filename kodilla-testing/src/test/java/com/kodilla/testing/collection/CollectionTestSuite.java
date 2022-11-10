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
        List<Integer> oddNumbersList = new ArrayList<>();
        oddNumbersList.add(1);
        oddNumbersList.add(3);
        oddNumbersList.add(5);
        oddNumbersList.add(7);
        oddNumbersList.add(9);

        List<Integer> evenNumbersList = new ArrayList<>();
        evenNumbersList.add(0);
        evenNumbersList.add(2);
        evenNumbersList.add(4);
        evenNumbersList.add(6);
        evenNumbersList.add(8);

        //When
        List<Integer> resultList = oddNumbersExterminator.exterminate(oddNumbersList);
        System.out.println("Testing odd numbers list");

        //Then
        Assertions.assertNotEquals(evenNumbersList, resultList);
    }
}