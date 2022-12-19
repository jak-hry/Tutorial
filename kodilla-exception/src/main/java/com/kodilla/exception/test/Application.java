package com.kodilla.exception.test;

public class Application {

    public static void main(String[] args) {

        FlightSearch flightSearch = new FlightSearch();

        Flight romaToBarcelona = new Flight("Roma", "Barcelona");
        Flight parisToMadrid = new Flight("Paris", "Madrid");
        Flight londonToWarsaw = new Flight("London", "Warsaw");

        try {
            boolean result = flightSearch.findFlight(romaToBarcelona);
            System.out.println("Flight Roma - Barcelona = " + result);
        } catch (RouteNotFoundException e){
            e.printStackTrace();
            System.out.println("Route unavailable");
        } finally {
            System.out.println("Search is ending");
        }

        try {
            boolean result = flightSearch.findFlight(parisToMadrid);
            System.out.println("Flight Paris - Madrid = " + result);
        } catch (RouteNotFoundException e){
            e.printStackTrace();
            System.out.println("Route unavailable");
        } finally {
            System.out.println("Search is ending");
        }

        try {
            boolean result = flightSearch.findFlight(londonToWarsaw);
            System.out.println("Flight London - Warsaw = " + result);
        } catch (RouteNotFoundException e){
            e.printStackTrace();
            System.out.println("Route unavailable");
        } finally {
            System.out.println("Search is ending");
        }
     }

}
