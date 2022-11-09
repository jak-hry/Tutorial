package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers) {

        List<Integer> newList = new ArrayList<>();

        for (Integer newExterminate : numbers) {
            if (newExterminate % 2 == 0) {
                newList.add(newExterminate);
            }
        }

        return newList;
    }
}




