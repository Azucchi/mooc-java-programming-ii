package ticTacToe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class TicTacLogic {
    
    private Button[][] layout;
    private Label label;
    private String playerLabel;
    private boolean turn;
    private boolean done;
    //if turn is false then it's X's turn
    
    public TicTacLogic(Label l, Button[][] input){
        this.layout = input;
        this.label = l;
        this.playerLabel = "X";
        l.setText("Turn: X");        
        this.turn = false;
        this.done = false;
    }
    
    public void initializeClicks(){
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                int xx = x;
                int yy = y;
                layout[x][y].setOnAction((event) ->{
                    if(layout[xx][yy].getText().isBlank() && !this.done){
                        layout[xx][yy].setText(playerLabel);
                        if(winChecker(this.turn)){
                            this.label.setText("The end!");
                        } else {
                            this.turn = !this.turn; 
                            turnChecker();
                        }                        
                                               
                    }                                   
                });
            }
        }
    }
    
    private void turnChecker(){
        if(this.turn){
            TurnO();
        } else {
            TurnX();
        }
    }
    
    private void TurnX(){
        this.playerLabel = "X";
        this.label.setText("Turn: X");
    }
    
    private void TurnO(){
        this.playerLabel = "O";
        this.label.setText("Turn: O");        
    }
    
    private boolean winChecker(boolean turn){
        String checker = "";
        if(turn){
            checker = "O";
        } else {
            checker = "X";
        }
        
        String[] values = readBoard();
        /*
        vertical values: 036, 147, 258
        horizontal values: 012, 345, 678
        diagonal values: 048, 246
        */
        for(int i = 0; i < 3; i++){
            //check vertical win
            if (values[i].equals(checker) && values[i].equals(values[i+3]) && values[i].equals(values[i+6])){
                this.done = true;
                return true;                
            }
        }
        
        for(int i = 0; i < 7; i+=3){
            //check horizontal win
            if (values[i].equals(checker) && values[i].equals(values[i+1]) && values[i].equals(values[i+2])){
                this.done = true;
                return true;
            }
        }
        
        //check diagonal win
        if (values[0].equals(checker) && values[0].equals(values[4]) && values[0].equals(values[8])){
                this.done = true;
                return true;
            }
        if (values[2].equals(checker) && values[2].equals(values[4]) && values[2].equals(values[6])){
                this.done = true;
                return true;
            }
        
        return false;
    }
    
    private String[] readBoard(){
        String[] returned = new String[9];
        int index = 0;
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                returned[index] = this.layout[x][y].getText();
                index++;
            }
        }
        return returned;
    }
}
