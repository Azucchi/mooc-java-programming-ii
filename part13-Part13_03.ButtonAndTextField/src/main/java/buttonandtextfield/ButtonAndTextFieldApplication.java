package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonAndTextFieldApplication extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        FlowPane objects = new FlowPane();
        TextField tf = new TextField("Bitch i have content already xd");
        Button button = new Button("I am a button!");
        objects.getChildren().add(button);
        objects.getChildren().add(tf);
        Scene scene = new Scene(objects);
        
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

    

}
