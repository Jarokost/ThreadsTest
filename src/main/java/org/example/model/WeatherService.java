package org.example.model;

import org.example.model.client.ClientInterface;

public class WeatherService {

    private final ClientInterface weatherClient;

    public WeatherService(ClientInterface weatherClient) {
        this.weatherClient = weatherClient;
    }

    public WeatherForecast getWeather() {
        return weatherClient.getWeather();
    }
}
