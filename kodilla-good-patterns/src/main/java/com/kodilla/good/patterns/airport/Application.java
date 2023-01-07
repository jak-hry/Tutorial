package com.kodilla.good.patterns.airport;

import java.util.HashSet;

public class Application {

    public static void main(String[] args) {

        Flight flight = new Flight();
        HashSet<Airport> list2 = flight.getRouteList();
        FlightService flightService = new FlightService();
        flightService.findFlightsFromAGivenCity(list2, "Gdynia");
        flightService.findFlightsToAGivenCity(list2, "Krakow");
    }
}
