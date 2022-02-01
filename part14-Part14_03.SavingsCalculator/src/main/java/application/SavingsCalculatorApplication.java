package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application{

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        UserInterface ui = new UserInterface();
        ui.start();
        
        Scene scene = ui.getScene();
        stage.setScene(scene);
        stage.show();
    }

}
