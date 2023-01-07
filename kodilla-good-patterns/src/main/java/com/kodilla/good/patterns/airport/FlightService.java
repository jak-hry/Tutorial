package com.kodilla.good.patterns.airport;

import java.util.HashSet;

public class FlightService {

    public void findFlightsFromAGivenCity(HashSet<Airport> list, String airportName) {

        list.stream()
                .filter(route -> route.getAirportNameFrom().equals(airportName))
                .forEach(System.out::println);

    }

    public void findFlightsToAGivenCity(HashSet<Airport> list, String airportName) {

        list.stream()
                .filter(route -> route.getAirportNameTo().equals(airportName))
                .forEach(System.out::println);

    }
}
