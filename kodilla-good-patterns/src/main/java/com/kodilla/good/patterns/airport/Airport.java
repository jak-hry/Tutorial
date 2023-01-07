package com.kodilla.good.patterns.airport;

import java.util.Objects;

public class Airport {

    private String airportNameFrom;
    private String airportNameTo;

    public Airport(String airportNameFrom, String airportNameTo) {
        this.airportNameFrom = airportNameFrom;
        this.airportNameTo = airportNameTo;
    }

    public String getAirportNameFrom() {
        return airportNameFrom;
    }

    public String getAirportNameTo() {
        return airportNameTo;
    }

    @Override
    public String toString() {
        return "departure from the airport \"" + airportNameFrom + "\" " +
                "to \"" + airportNameTo + "\"";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport airport)) return false;
        return Objects.equals(airportNameFrom, airport.airportNameFrom) && Objects.equals(airportNameTo, airport.airportNameTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportNameFrom, airportNameTo);
    }
}
