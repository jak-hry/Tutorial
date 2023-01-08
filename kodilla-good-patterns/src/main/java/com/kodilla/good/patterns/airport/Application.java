package com.kodilla.good.patterns.airport;

import java.util.HashSet;

public class Application {

    public static void main(String[] args) {

        Flight flight = new Flight();
        HashSet<Airport> list2 = flight.getRouteList();
        FlightService flightService = new FlightService();
        flightService.searchFrom(list2, "Gdansk");
        flightService.searchTo(list2, "Krakow");
        System.out.println();
        flightService.searchThroughAnotherCity(list2, "Warszawa", "Poznan", "Wroclaw");
    }
}
