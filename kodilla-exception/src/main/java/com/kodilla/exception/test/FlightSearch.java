package com.kodilla.exception.test;

import java.util.HashMap;

public class FlightSearch {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {

        HashMap<String, Boolean> flightsMap = new HashMap<>();

        flightsMap.put("Barcelona", true);
        flightsMap.put("Warsaw", false);
        flightsMap.put("London", true);
        flightsMap.put("Paris", false);
        flightsMap.put("Madrid", true);
        flightsMap.put("Roma", true);

        if (flightsMap.containsKey(flight.getArrivalAirport()) && flightsMap.containsKey(flight.getDepartureAirport())) {
            if (flightsMap.get(flight.getArrivalAirport()) && flightsMap.get(flight.getDepartureAirport())) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new RouteNotFoundException("Arrival or departure from the airport is not available");
        }
    }

}
