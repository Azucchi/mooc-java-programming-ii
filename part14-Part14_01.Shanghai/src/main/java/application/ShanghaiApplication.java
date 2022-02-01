package application;

import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application{

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        HashMap<Integer, Double> data = new HashMap<>();
        data.put(1, 3.0);
        data.put(2, 3.2);
        data.put(3, 3.3);
        data.put(4, 3.6);
        data.put(5, 4.0);
        data.put(6, 4.2);
        data.put(7, 4.5);
        data.put(8, 4.7);
        data.put(9, 4.9);
        data.put(10, 5.0);
        data.put(11, 5.1);
        
        NumberAxis xAxis = new NumberAxis(0, 10, 1);
        NumberAxis yAxis = new NumberAxis();
        
        xAxis.setLabel("seconds");
        yAxis.setLabel("pp size");
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("pp size over time");
        XYChart.Series plot = new XYChart.Series();
        
        
        data.entrySet().stream()
                .forEach(year -> {
                    plot.getData().add(new XYChart.Data(year.getKey(), year.getValue()));
                });
        
        lineChart.getData().add(plot);
        
        Scene scene = new Scene(lineChart, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

}
