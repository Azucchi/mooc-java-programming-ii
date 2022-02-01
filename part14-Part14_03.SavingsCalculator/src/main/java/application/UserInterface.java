/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Slider;

/**
 *
 * @author reroy
 */
public class UserInterface {
    
    private BorderPane overallWindow; //created
    private NumberAxis x;
    private NumberAxis y;
    private LineChart<Number, Number> lineChart; //created
    private VBox top; //created
    private Scene outputScene;
    private XYChart.Series actualData;
    private SavingsLogic savingsPerMonth;
    private XYChart.Series actualDataInterest;
    
    public void start(){
        this.savingsPerMonth = new SavingsLogic(25);
        this.savingsPerMonth.setInterest(0);
        createOverallBorderPane();
        System.out.println("the ui has started");
    }
    
    private void createOverallBorderPane(){
        this.overallWindow = new BorderPane();
        createLineChart();
        createTopVBox();
        System.out.println("createOverallBorderPane started");
    }
    
    private void createLineChart(){
        this.x = new NumberAxis(0, 30, 1);
        this.y = new NumberAxis();
        this.x.setLabel("Year");
        this.y.setLabel("Interest rate");
        
        this.lineChart = new LineChart<>(x, y);
        this.actualData = new XYChart.Series();
        this.actualDataInterest = new XYChart.Series();
        
        this.lineChart.getData().add(this.actualData);
        this.lineChart.getData().add(this.actualDataInterest);
        System.out.println("createLineChart started");
        
        
    }

    private void createTopVBox() {
        this.top = new VBox(30);        
        createVBoxComponents();
        System.out.println("create TopVBox started");
    }
    
    private void createVBoxComponents(){
        //top borderpane
        createvBoxTopPane();
        createvBoxBottomPane();
        System.out.println("create VBoxComponents started");
    }
    
    private void createvBoxTopPane(){
        BorderPane topBorderPane = new BorderPane();
        Label label = new Label("Monthly savings");
        Slider monthlySavingsSlider = new Slider(25, 250, 25);
        monthlySavingsSlider.setShowTickLabels(true);
        monthlySavingsSlider.setShowTickMarks(true);
        Label savingsLabel = new Label();        
        
        savingsLabel.textProperty().bind(
            Bindings.format(
                "%.0f",
                monthlySavingsSlider.valueProperty()                
            )
        );
        
        for(int i = 0; i < 31; i++){
                    actualData.getData().add(new XYChart.Data(i, savingsPerMonth.getTotalSavings(i)));
                }
        
        monthlySavingsSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                savingsPerMonth.setSavingsPerMonth((int) monthlySavingsSlider.getValue());
                System.out.println(savingsPerMonth.getSavingsPerMonth());
                actualData.getData().clear();
                actualDataInterest.getData().clear();
                for(int i = 0; i < 31; i++){
                    actualData.getData().add(new XYChart.Data(i, savingsPerMonth.getTotalSavings(i)));
                    actualDataInterest.getData().add(new XYChart.Data(i, savingsPerMonth.savingsWithInterest(i)));
                    System.out.println("Year:" + i + ", Savings: " + savingsPerMonth.getTotalSavings(i));
                }
            }
            
        });

        topBorderPane.setLeft(label);
        topBorderPane.setCenter(monthlySavingsSlider);
        topBorderPane.setRight(savingsLabel);
        this.top.getChildren().add(topBorderPane);
        System.out.println("create createvBoxTopPane started");
    }

    private void createvBoxBottomPane() {
        BorderPane bottomBorderPane = new BorderPane();
        Label label = new Label("Yearly interest rate");
        Slider yearlyInterestSlider = new Slider(0, 10, 0);
        yearlyInterestSlider.setShowTickLabels(true);
        yearlyInterestSlider.setShowTickMarks(true);
        Label interestLabel = new Label();
        
        
        interestLabel.textProperty().bind(
            Bindings.format(
                "%.0f",
                yearlyInterestSlider.valueProperty()
            )
        );
        
        for(int i = 0; i < 31; i++){
                    actualDataInterest.getData().add(new XYChart.Data(i, savingsPerMonth.savingsWithInterest(i)));
                }
        
        yearlyInterestSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                actualDataInterest.getData().clear();
                savingsPerMonth.setInterest((int) yearlyInterestSlider.getValue());
                for(int i = 0; i < 31; i++){
                    actualDataInterest.getData().add(new XYChart.Data(i, savingsPerMonth.savingsWithInterest(i)));
                    System.out.println("Year:" + i + ", Savings: " + savingsPerMonth.savingsWithInterest(i));
                }
            }
            
        });

        
    
        bottomBorderPane.setLeft(label);
        bottomBorderPane.setCenter(yearlyInterestSlider);
        bottomBorderPane.setRight(interestLabel);
        this.top.getChildren().add(bottomBorderPane);
        System.out.println("create createvBoxBottomPane started");
    }
    
    private void collectAll(){
        this.overallWindow.setCenter(this.lineChart);
        this.overallWindow.setTop(this.top);
        this.outputScene = new Scene(overallWindow, 480, 360);
        System.out.println("collectAll started");
    }
    
    public Scene getScene(){
        this.collectAll();
        System.out.println("getScene started");
        return this.outputScene;        
    }
    
    
    
}
