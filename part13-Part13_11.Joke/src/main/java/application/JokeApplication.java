package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JokeApplication extends Application{


    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        HBox h = new HBox();
        Button joke = new Button("Joke");
        Button answer = new Button("Answer");
        Button explanation = new Button("Explanation");
        h.getChildren().addAll(joke, answer, explanation);
        
        BorderPane gp = new BorderPane();
        gp.setTop(h);
        Label bottom = new Label("What do you call a bear with no teeth?");
        gp.setBottom(bottom);
        
        joke.setOnAction((event) -> {
            bottom.setText("What do you call a bear with no teeth?");
        });
        
        answer.setOnAction((event) -> {
            bottom.setText("A gummy bear.");
        });
        
        explanation.setOnAction((event) -> {
            bottom.setText("my life is a joke");
        });
        
        Scene scene = new Scene(gp);
        stage.setScene(scene);
        stage.show();
        
    }
}
