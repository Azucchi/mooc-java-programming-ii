
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
public class Box implements Packable{
    
    private double maxWeight;
  //  private double weight;
    private ArrayList<Packable> contents;
    
    public Box(double maxWeight){
        this.maxWeight = maxWeight;
       // this.weight = 0.0;
        contents = new ArrayList<>();
    }
    
    public void add(Packable item){
        if(item.weight() + this.weight() <= maxWeight){
            contents.add(item);
        }
    }
    
    @Override
    public String toString(){
        return "Box: " + contents.size() + " items, total weight " + this.weight() + " kg";
    }
    
    public double weight(){
        double weight = 0;
        for(Packable each: contents){
            weight += each.weight();
        }
        return weight;
    }
    
    
}
