package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.view.ViewFactory;

import static javafx.application.Application.launch;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showMainWindow();
    }
}
