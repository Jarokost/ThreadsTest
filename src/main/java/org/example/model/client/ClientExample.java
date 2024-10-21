package org.example.model.client;

import org.example.model.WeatherForecast;

import java.util.Random;


public class ClientExample implements ClientInterface {

    @Override
    public WeatherForecast getWeather() {
        Random rand = new Random();
        int n = rand.nextInt(50) + 1;
        return new WeatherForecast(n);
    }

}
