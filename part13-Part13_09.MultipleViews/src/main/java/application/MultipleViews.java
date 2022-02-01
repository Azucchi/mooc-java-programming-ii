package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application{

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //first Scene
        BorderPane bp1 = new BorderPane();
        Label top1 = new Label("First View!");
        Button b1 = new Button("To the second view!");
        bp1.setTop(top1);
        bp1.setCenter(b1);        
        Scene firstScene = new Scene(bp1);    
        
        //second scene        
        VBox vb = new VBox();
        Button b2 = new Button("To the third view!");
        Label l2 = new Label("Second view!");
        vb.getChildren().addAll(b2, l2);
        Scene secondScene = new Scene(vb);
        
        //third scene
        GridPane gp = new GridPane();
        Label l3 = new Label("Third view!");
        Button b3 = new Button("To the first view!");
        gp.add(l3, 0, 0);
        gp.add(b3, 1, 1);
        Scene thirdScene = new Scene(gp);
        
        
        b1.setOnAction((event) ->{
            stage.setScene(secondScene);
        });
        
        b2.setOnAction((event) -> {
            stage.setScene(thirdScene);
        });
        
        b3.setOnAction((event) -> {
            stage.setScene(firstScene);
        });
        
        stage.setScene(firstScene);
        stage.show();
    }

}
