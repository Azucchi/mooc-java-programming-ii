package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GreeterApplication extends Application{


    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        //first Scene
        //creation of elements
        Label instructions = new Label("Enter your name and start.");
        TextField nameInput = new TextField();
        Button b = new Button("Start");
        
        //layout:
        VBox vb = new VBox();
        vb.getChildren().addAll(instructions, nameInput, b);
        vb.setSpacing(30);
        Scene first = new Scene(vb);
        
        //second Scene
        String nameOutput = "";
        BorderPane bp = new BorderPane();
        Label name = new Label("Hello, " + nameOutput);
        bp.setCenter(name);
        Scene second = new Scene(bp);
        
        //button functionality:
        b.setOnAction((event) -> {
            name.setText("Welcome " + nameInput.getText() + "!");
            stage.setScene(second);
            
        });
        
        //start
        stage.setScene(first);
        stage.show();
        
    }
}
