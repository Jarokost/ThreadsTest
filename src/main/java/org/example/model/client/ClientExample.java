package org.example.model.client;

import org.example.model.WeatherForecast;

import java.util.Random;


public class ClientExample implements ClientInterface {

    WeatherForecast weatherForecast;

    @Override
    public WeatherForecast getWeather() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                weatherForecast = getWeatherAPI();
                try { Thread.sleep(1000); } catch (InterruptedException e) { }
            }
        });
        thread.start();

        try { thread.join(); } catch (InterruptedException e) { }

        return weatherForecast;
    }

    private WeatherForecast getWeatherAPI() {
        Random rand = new Random();
        int n = rand.nextInt(50) + 1;
        return new WeatherForecast(n);
    }
}
