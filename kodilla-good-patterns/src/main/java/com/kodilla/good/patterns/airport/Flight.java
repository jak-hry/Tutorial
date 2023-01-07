package com.kodilla.good.patterns.airport;

import java.util.HashSet;

public class Flight {

    private HashSet<Airport> airportsList = new HashSet<>();

    public Flight() {

        airportsList.add(new Airport("Warszawa", "Wroclaw"));
        airportsList.add(new Airport("Wroclaw", "Poznan"));
        airportsList.add(new Airport("Poznan", "Krakow"));
        airportsList.add(new Airport("Krakow", "Gdansk"));
        airportsList.add(new Airport("Gdansk", "Warszawa"));

    }

    public HashSet<Airport> getRouteList() {

        return airportsList;
    }
}
