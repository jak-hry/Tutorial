package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    @BeforeEach
    public void beforeEachTest() {
        Map<String, Double> temperatureMap = new HashMap<>();
        temperatureMap.put("Rzeszow", 25.5);
        temperatureMap.put("Krakow", 26.2);
        temperatureMap.put("Wroclaw", 24.8);
        temperatureMap.put("Warszawa", 25.2);
        temperatureMap.put("Gdansk", 26.1);

        when(temperaturesMock.getTemperatures()).thenReturn(temperatureMap);
    }

    @Mock
    private Temperatures temperaturesMock;

    @Test
    void testCalculateForecastWithMock() {

        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateAverageTemperature() {

        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double averageTemperatures = weatherForecast.calculateAverageTemperature(temperaturesMock.getTemperatures());

        //Then
        Assertions.assertEquals(25.56, averageTemperatures);

    }

    @Test
    void testCalculateAverageMedianTemperature() {

        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double averageMedianTemperatures = weatherForecast.calculateAverageMedianTemperature(temperaturesMock.getTemperatures());

        //Then
        Assertions.assertEquals(25.5, averageMedianTemperatures);
    }
}





