
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reroy
 */
public class Herd implements Movable{
    
    private ArrayList<Movable> herd;
    
    public Herd(){
        this.herd = new ArrayList<>();
    }
    
    public String toString(){
        String output = "";
        for(Movable each:herd){
            output += each + "\n";
        }
        return output;
    }
    
    public void addToHerd(Movable movable){
        this.herd.add(movable);
    }
    
    public void move (int dx, int dy){
        for(Movable each:herd){
            each.move(dx, dy);
        }
    }
    
}
