package ticTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application{


    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        GridPane tictactoeLayout = new GridPane();
        Label l = new Label("Turn: ");
        l.setFont(Font.font("Monospaced", 30));
        

        
        Button[][] layouts = new Button[3][3];
        
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                Button newButton = new Button(" ");
                newButton.setFont(Font.font("Monospaced", 40));
                layouts[x][y] = newButton;
                tictactoeLayout.add(newButton, x, y);
            }
        }
        
        bp.setTop(l);
        bp.setCenter(tictactoeLayout);
        
        //initialize Logic
        
        TicTacLogic ttt = new TicTacLogic(l, layouts);
        ttt.initializeClicks();
        
        Scene scene = new Scene(bp, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

}
