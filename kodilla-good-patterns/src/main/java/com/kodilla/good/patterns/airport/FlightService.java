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

        Set<Airport> result = list.stream()
                .filter(route -> route.getAirportNameFrom().equals(airportNameFrom))
                .filter(route -> route.getAirportNameTo().equals(airportNameTo))
                .collect(Collectors.toSet());

        if (result.size() > 0) {
            Airport airport = new Airport(airportNameTo, anotherCity);
            list.add(airport);
            System.out.println("flight from \"" + airportNameFrom +
                    "\" through \"" + anotherCity + "\" to \"" + airportNameTo + "\"");
        }
    }
}
