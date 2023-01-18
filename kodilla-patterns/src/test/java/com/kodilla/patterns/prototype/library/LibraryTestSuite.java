package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {

        //Given
        Library library = new Library("test library 1");
        for (int i = 1; i < 10; i++) {
            library.getBooks().add(new Book("book" + i, "author" + i,
                    LocalDate.now().minusWeeks(i).minusMonths(i).minusYears(i)));
        }

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("test library 2");
        } catch (CloneNotSupportedException e) {
            System.out.println("Exception - " + e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("test library 3");
        } catch (CloneNotSupportedException e) {
            System.out.println("Exception - " + e);
        }
        //When
        library.getBooks().removeIf(book -> book.getPublicationDate()
                .isAfter(LocalDate.of(2018, 1, 1)));

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        assertEquals(5, library.getBooks().size());
        assertEquals(5, clonedLibrary.getBooks().size());
        assertEquals(9, deepClonedLibrary.getBooks().size());
        assertEquals(library.getBooks(), clonedLibrary.getBooks());
        assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());
    }
}
