package com.kodilla.exception.test;

import java.util.HashMap;

public class FlightSearch {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {

        HashMap<String, Boolean> flightsMap = new HashMap<>();

        flightsMap.put("Barcelona", true);
        flightsMap.put("Warsaw", true);
        flightsMap.put("London", true);
        flightsMap.put("Paris", true);
        flightsMap.put("Madrid", true);
        flightsMap.put("Roma", true);
        flightsMap.put("Berlin", false);
        flightsMap.put("Dublin", false);
        flightsMap.put("Amsterdam", false);

        if (flightsMap.containsKey(flight.getArrivalAirport()) && flightsMap.containsKey(flight.getDepartureAirport())) {
            return true;
        } else {
            throw new RouteNotFoundException("Arrival or departure from the airport is not available");
        }
    }

}
