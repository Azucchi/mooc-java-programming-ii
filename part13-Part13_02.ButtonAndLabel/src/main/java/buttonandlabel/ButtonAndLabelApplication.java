package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;



public class ButtonAndLabelApplication extends Application{
    
    @Override
    public void start(Stage stage){
        
        FlowPane controller = new FlowPane();
        Label label = new Label("Label");
        Button button = new Button("Button");
        controller.getChildren().add(label);
        controller.getChildren().add(button);
        Scene view = new Scene(controller);
        
        stage.setScene(view);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

    

}
