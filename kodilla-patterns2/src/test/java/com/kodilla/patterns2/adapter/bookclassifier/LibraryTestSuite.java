package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.BookA;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTestSuite {

    @Test
    public void publicationYearMedianTest() {

        //Given
        BookA book1 = new BookA("test1", "test2", 1990, "01");
        BookA book2 = new BookA("test2", "test3", 1980, "02");
        BookA book3 = new BookA("test3", "test4", 1970, "03");
        BookA book4 = new BookA("test4", "test5", 1960, "04");
        BookA book5 = new BookA("test5", "test6", 1950, "05");
        Set<BookA> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int medianResult = medianAdapter.publicationYearMedian(books);
        //Then
        assertEquals(1970, medianResult);
        assertEquals(5, books.size());
    }
}
