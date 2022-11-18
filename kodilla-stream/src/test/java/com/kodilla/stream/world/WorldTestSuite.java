package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {

        //Given
        World world = new World();
        Continent europe = new Continent("Europe");
        Continent asia = new Continent("Asia");
        Continent africa = new Continent("Africa");
        world.addContinent(europe);
        world.addContinent(asia);

        BigDecimal peoplePoland = new BigDecimal("40000000");
        BigDecimal peopleGermany = new BigDecimal("85000000");
        BigDecimal peopleSpain = new BigDecimal("45000000");
        BigDecimal peopleAustria = new BigDecimal("10000000");
        Country countryPoland = new Country("Poland", peoplePoland);
        Country countryGermany = new Country("Germany", peopleGermany);
        Country countrySpain = new Country("Spain", peopleSpain);
        Country countryAustria = new Country("Austria", peopleAustria);

        BigDecimal peopleCyprus = new BigDecimal("1000000");
        BigDecimal peopleEgypt = new BigDecimal("100000000");
        BigDecimal peopleLebanon = new BigDecimal("5000000");
        Country countryCyprus = new Country("Cyprus", peopleCyprus);
        Country countryEgypt = new Country("Egypt", peopleEgypt);
        Country countryLebanon = new Country("Lebanon", peopleLebanon);

        //When
        europe.addCountry(countryPoland);
        europe.addCountry(countryGermany);
        europe.addCountry(countrySpain);
        europe.addCountry(countryAustria);

        asia.addCountry(countryCyprus);
        asia.addCountry(countryEgypt);
        asia.addCountry(countryLebanon);

        //Then
        BigDecimal expectedWorldPeople = new BigDecimal("286000000");
        BigDecimal peopleQuantity = world.getPeopleQuantity();

        assertEquals(4, europe.getCountry().size());
        assertEquals(3, asia.getCountry().size());
        assertEquals(0, africa.getCountry().size());
        assertEquals(expectedWorldPeople, peopleQuantity);

        assertTrue(europe.getCountry().contains(countryPoland));
        assertTrue(europe.getCountry().contains(countryGermany));
        assertTrue(asia.getCountry().contains(countryCyprus));
        assertTrue(asia.getCountry().contains(countryEgypt));

        assertTrue(world.getContinent().contains(europe));
        assertTrue(world.getContinent().contains(asia));
        assertFalse(world.getContinent().contains(africa));
    }
}
