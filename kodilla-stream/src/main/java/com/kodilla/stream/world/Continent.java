package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {

    private final String name;

    private final List<Country> countries = new ArrayList<>();

    public List<Country> getCountry() {
        return countries;
    }

    public void addCountry(Country country) {
        countries.add(country);
    }

    public Continent(String name) {
        this.name = name;
    }
}
