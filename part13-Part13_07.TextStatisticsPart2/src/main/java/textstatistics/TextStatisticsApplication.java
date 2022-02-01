package textstatistics;

import java.util.Arrays;
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
        Label lettersLabel = new Label("Letters: ");
        Label wordsLabel = new Label("Words: ");
        Label longestLabel = new Label("The longest word is: ");
        HBox bottom = new HBox();
        bottom.setSpacing(20);
        bottom.getChildren().add(lettersLabel);
        bottom.getChildren().add(wordsLabel);
        bottom.getChildren().add(longestLabel);
        
        text.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] words = newValue.split(" ");
            int wordCount = words.length;
            String longest = Arrays.stream(words)
                    .sorted((w1, w2) -> w2.length() - w1.length())
                    .findFirst()
                    .get();
            lettersLabel.setText("Letters: " + characters);
            wordsLabel.setText("Words: " + wordCount);
            longestLabel.setText("The longest word is: " + longest);
        
        });
        
        layout.setCenter(text);

        layout.setBottom(bottom);
        
        
        
        
        
        
        
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.setTitle("HELLO I AM TITLE BAR WOOOOOO");
        stage.show();
    }

}
