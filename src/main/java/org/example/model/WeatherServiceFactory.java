package org.example.model;

import org.example.model.client.ClientExample;
import org.example.model.client.ClientInterface;

public class WeatherServiceFactory {

    public static WeatherService createWeatherService() {
        return new WeatherService(createWeatherClient());
    }

    private static ClientInterface createWeatherClient() {
        return new ClientExample();
    }
}
