package com.kodilla.good.patterns.challenges;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class Application {

    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();

        Map<String, List<String>> movies = movieStore.getMovies();

        String movie = movies.values().stream()
                .map(s -> s.toString())
                .collect(joining(" ! "));
        System.out.println(movie);

    }
}
