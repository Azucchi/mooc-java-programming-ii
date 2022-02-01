package application;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application{

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {        
        ArrayList<String[]> data = readFile();
        
        NumberAxis xAxis = new NumberAxis(1965, 2010, 4);
        xAxis.setLabel("Year");
        
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Relative support of the parties");
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        XYChart.Series KOK = createSeries("KOK", data);
        XYChart.Series SDP = createSeries("SDP", data);
        XYChart.Series KESK = createSeries("KESK", data);
        XYChart.Series VIHR = createSeries("VIHR", data);
        XYChart.Series VAS = createSeries("VAS", data);
        XYChart.Series PS = createSeries("PS", data);
        XYChart.Series RKP = createSeries("RKP", data);
        
        lineChart.getData().add(KOK);
        lineChart.getData().add(SDP);
        lineChart.getData().add(KESK);
        lineChart.getData().add(VIHR);
        lineChart.getData().add(VAS);
        lineChart.getData().add(PS);
        lineChart.getData().add(RKP);
        
        Scene view = new Scene(lineChart);
        stage.setScene(view);
        stage.show();
        
    }

    private ArrayList<String[]> readFile() {
        ArrayList<String[]> rawData = new ArrayList<>();
        try {
            Scanner fileReader = new Scanner(Paths.get("partiesdata.tsv"));
            while(fileReader.hasNext()){
                String[] data = fileReader.nextLine().split("\t");
                rawData.add(data);
            }
        } catch (IOException ex) {
            Logger.getLogger(PartiesApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rawData;
    }
    
    private XYChart.Series createSeries(String party, ArrayList<String[]> data){
        XYChart.Series returned = new XYChart.Series();
        returned.setName(party);
        
        for(String[] each: data){
            if(each[0].equals(party)){
                for(int i = 1; i <= 11; i++){
                    double percentage = 0.0;
                    if(each[i].equals("-")){
                        
                    } else {
                        percentage = Double.valueOf(each[i]);
                    }
                    int year = Integer.valueOf(data.get(0)[i]);
                    if(percentage > 0){
                        returned.getData().add(new XYChart.Data(year, percentage));
                    }                    
                }
            }
        }
        
        return returned;
    }

}
