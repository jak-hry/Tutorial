package com.kodilla.testing.forum.shape.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
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

        //When
        List<Integer> resultList = oddNumbersExterminator.exterminate(oddNumbersList);
        System.out.println("Testing odd numbers list");

        //Then
        Assertions.assertEquals(0, resultList.size());
    }

    @Test
    void testOddNumbersExterminator() {

        //Given
        List<Integer> oddNumbersList = new ArrayList<>();
        oddNumbersList.add(1);
        oddNumbersList.add(2);
        oddNumbersList.add(3);
        oddNumbersList.add(5);
        oddNumbersList.add(7);
        oddNumbersList.add(9);

        //When
        List<Integer> resultList = oddNumbersExterminator.exterminate(oddNumbersList);
        System.out.println("Testing odd numbers list");

        //Then
        Assertions.assertEquals(1, resultList.size());
        Assertions.assertEquals(2, resultList.get(0));
    }
}