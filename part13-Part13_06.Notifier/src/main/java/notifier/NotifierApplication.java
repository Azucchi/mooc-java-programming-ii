package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NotifierApplication extends Application{


    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox vbox = new VBox();
        TextField tf = new TextField();
        Button b = new Button("Update");
        Label l = new Label();
        
        b.setOnAction((event) ->{
            l.setText(tf.getText());
        });
        
        vbox.getChildren().addAll(tf, b, l);
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }

}
