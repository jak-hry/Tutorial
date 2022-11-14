package com.kodilla.testing.forum.statistics;

import java.util.List;

interface Statistics {

    List<String> usersNames(); // lista użytkowników
    int postsCount(); // łączna liczba postów na forum
    int commentsCount(); // łączna liczba komentarzy na forum
}
