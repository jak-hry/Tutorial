package com.kodilla.testing.library;

import java.util.List;

public interface LibraryDatabase {

    //wyświetla książki, których tytuł zaczyna się od titleFragment
    List<Book> listBooksWithCondition(String titleFragment);

    //lista książek wypożyczonych przez użytkownika biblioteki
    List<Book> listBooksInHandsOf(LibraryUser libraryUser);

    // spróbuj wypożyczyć książkę użytkownikowi libraryUser
    // zwraca true po sukcesie
    // i zwraca wartość false, gdy książka jest niedostępna do wypożyczenia
    boolean rentABook(LibraryUser libraryUser, Book book);

    // zwrócić wszystkie książki wypożyczone przez użytkownika biblioteki do biblioteki
    // zwraca liczbę zwróconych książek
    int returnBooks(LibraryUser libraryUser);
}
