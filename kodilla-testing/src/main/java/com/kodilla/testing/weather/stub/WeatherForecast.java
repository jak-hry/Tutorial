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

    public double calculateAverageTemperature(Map<String, Double> averageTemp) {

        double resultOfAverage = 0;
        for (Double temperature : temperatures.getTemperatures().values()) {
            resultOfAverage += temperature;
        }
        return resultOfAverage / (double) averageTemp.size();
    }

    public double calculateAverageMedianTemperature(Map<String, Double> averageMedianTemp) {
        List<Double> result = new ArrayList<>();

        for (Map.Entry<String, Double> temperature : averageMedianTemp.entrySet()) {
            result.add(temperature.getValue());
        }

        Collections.sort(result);
        double median;

        if (result.size() % 2 != 0) {
            median = result.get(result.size() / 2);
        } else {
            median = (result.get(result.size() / 2)) + (result.get(result.size() / 2 - 1));
        }

        return median;
    }
}