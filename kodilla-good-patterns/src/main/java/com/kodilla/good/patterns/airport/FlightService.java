package com.kodilla.good.patterns.airport;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightService {

    public void searchFrom(HashSet<Airport> list, String airportName) {

        list.stream()
                .filter(route -> route.getAirportNameFrom().equals(airportName))
                .forEach(System.out::println);

    }

    public void searchTo(HashSet<Airport> list, String airportName) {

        list.stream()
                .filter(route -> route.getAirportNameTo().equals(airportName))
                .forEach(System.out::println);

    }

    public void searchThroughAnotherCity(HashSet<Airport> list, String airportNameFrom, String airportNameTo, String anotherCity) {

        list.stream()
                .filter(route -> route.getAirportNameFrom().equals(airportNameFrom))
                .filter(route -> route.getAirportNameTo().equals(airportNameTo))
                .collect(Collectors.toSet());

    }
}
