package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application{


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage stage){
        BorderPane layout = new BorderPane();
        TextArea text = new TextArea();
        layout.setCenter(text);
        HBox bottom = new HBox();
        Label letters = new Label("Letters: 0");
        Label words = new Label("Words: 0");
        Label longest = new Label("The longest word is: ");
        bottom.setSpacing(20);
        bottom.getChildren().add(letters);
        bottom.getChildren().add(words);
        bottom.getChildren().add(longest);
        layout.setBottom(bottom);
        
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

}
