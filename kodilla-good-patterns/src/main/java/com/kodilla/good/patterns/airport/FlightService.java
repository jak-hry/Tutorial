package com.kodilla.good.patterns.airport;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

        Set<Airport> result1 = list.stream()
                .filter(route -> route.getAirportNameFrom().equals(airportNameFrom))
                .filter(route -> route.getAirportNameTo().equals(anotherCity))
                .collect(Collectors.toSet());

        Set<Airport> result2 = list.stream()
                .filter(route -> route.getAirportNameFrom().equals(anotherCity))
                .filter(route -> route.getAirportNameTo().equals(airportNameTo))
                .collect(Collectors.toSet());

        if (result1.size() > 0 && result2.size() > 0) {
            System.out.println(result1);
            System.out.println(result2);
        } else {
            System.out.println("this route is not available");
        }
    }
}

