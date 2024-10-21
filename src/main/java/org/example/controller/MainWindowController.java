package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.example.model.WeatherForecast;
import org.example.model.WeatherService;
import org.example.model.WeatherServiceFactory;
import org.example.view.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {

    @FXML
    private Label labelLeft;

    @FXML
    private Label labelRight;

    private WeatherService weatherServiceLeft;
    private WeatherService weatherServiceRight;
    private WeatherForecast weatherForecastLeft;
    private WeatherForecast weatherForecastRight;

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weatherServiceLeft = WeatherServiceFactory.createWeatherService();
        weatherServiceRight = WeatherServiceFactory.createWeatherService();
    }

    @FXML
    void clickLeft(ActionEvent event) {
        System.out.println("left clicked!");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                weatherForecastLeft = weatherServiceLeft.getWeather();
                try { Thread.sleep(3000); } catch (InterruptedException e) { }
            }
        });
        thread.start();

        try { thread.join(); } catch (InterruptedException e) { }

        displayWeatherLeft(weatherForecastLeft);
    }

    @FXML
    void clickRight(ActionEvent event) {
        System.out.println("right clicked!");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                weatherForecastRight = weatherServiceRight.getWeather();
                try { Thread.sleep(3000); } catch (InterruptedException e) { }
            }
        });
        thread.start();

        try { thread.join(); } catch (InterruptedException e) { }

        if(!thread.isAlive()) {
            displayWeatherRight(weatherForecastRight);
        }
    }

    private void displayWeatherLeft(WeatherForecast weatherForecast) {
        labelLeft.setText(String.valueOf(weatherForecast.getNumber()));
    }

    private void displayWeatherRight(WeatherForecast weatherForecast) {
        labelRight.setText(String.valueOf(weatherForecast.getNumber()));
    }
}
