package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    @Test
    void testCalculateForecastWithMock() {

        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);
        Map<String, Double> temperatureMap = new HashMap<>();
        temperatureMap.put("Rzeszow", 25.5);
        temperatureMap.put("Krakow", 26.2);
        temperatureMap.put("Wroclaw", 24.8);
        temperatureMap.put("Warszawa", 25.2);
        temperatureMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperatureMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateAverageTemperature() {

        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);
        Map<String, Double> temperatureMap = new HashMap<>();
        temperatureMap.put("Rzeszow", 25.5);
        temperatureMap.put("Krakow", 26.2);
        temperatureMap.put("Wroclaw", 24.8);
        temperatureMap.put("Warszawa", 25.2);
        temperatureMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperatureMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double averageTemperatures = weatherForecast.calculateAverageTemperature(temperaturesMock.getTemperatures());

        //Then
        Assertions.assertEquals(25.56, averageTemperatures);

    }

    @Test
    void testCalculateAverageMedianTemperature() {

        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);
        Map<String, Double> temperatureMap = new HashMap<>();
        temperatureMap.put("Rzeszow", 25.5);
        temperatureMap.put("Krakow", 26.2);
        temperatureMap.put("Wroclaw", 24.8);
        temperatureMap.put("Warszawa", 25.2);
        temperatureMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperatureMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double averageMedianTemperatures = weatherForecast.calculateAverageMedianTemperature(temperaturesMock.getTemperatures());

        //Then
        Assertions.assertEquals(25.5, averageMedianTemperatures);
    }

    @Test
    void anotherTestOnCalculateAverageMedianTemperature() {

        //Given
        Temperatures medianTemperaturesMock = mock(Temperatures.class);
        Map<String, Double> medianTemperatureMap = new HashMap<>();
        medianTemperatureMap.put("Rzeszow", 25.5);
        medianTemperatureMap.put("Krakow", 26.2);
        medianTemperatureMap.put("Wroclaw", 24.8);
        medianTemperatureMap.put("Warszawa", 25.2);
        medianTemperatureMap.put("Gdansk", 26.1);
        medianTemperatureMap.put("Torun", 24.3);
        when(medianTemperaturesMock.getTemperatures()).thenReturn(medianTemperatureMap);

        WeatherForecast weatherForecast = new WeatherForecast(medianTemperaturesMock);

        //When
        double averageMedianTemperatures = weatherForecast.calculateAverageMedianTemperature(medianTemperaturesMock.getTemperatures());

        //Then
        Assertions.assertEquals(25.350, averageMedianTemperatures);
    }
}





