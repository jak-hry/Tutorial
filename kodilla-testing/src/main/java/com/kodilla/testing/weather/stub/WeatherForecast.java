package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {

        double resultOfAverage = 0;
        for (Double temperature : temperatures.getTemperatures().values()) {
            resultOfAverage += temperature;
        }
        return resultOfAverage / temperatures.getTemperatures().size();
    }

    public double calculateAverageMedianTemperature() {
        List<Double> result = new ArrayList<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            result.add(temperature.getValue());
        }

        Collections.sort(result);
        double median = 0.0;

        if (result.size() % 2 != 0) {
            median = result.get(result.size() / 2);
        } else {
            median = (result.get(result.size() / 2) + result.get(result.size() / 2 - 1)) / 2;
        }

        return median;
    }
}
