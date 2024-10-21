package org.example.model;

import java.time.LocalDate;
import java.util.Collection;

public class WeatherForecast {

    private final int number;

    public WeatherForecast(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
