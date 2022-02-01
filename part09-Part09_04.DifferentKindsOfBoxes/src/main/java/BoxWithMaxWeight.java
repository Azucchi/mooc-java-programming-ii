
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
public class BoxWithMaxWeight extends Box{
    
    private int maxWeight;
    private ArrayList<Item> contents;
    
    
    public BoxWithMaxWeight(int capacity){
        this.maxWeight = capacity;
        this.contents = new ArrayList<>();
    }
    
    @Override
    public void add(Item item){
        int weight = 0;
        for (Item each:contents){
            weight += each.getWeight();
        }
        
        if(item.getWeight() + weight <= maxWeight){
            contents.add(item);
        }
    }
    
    
    @Override
    public boolean isInBox(Item item){
        if(contents.contains(item)){
            return true;
        }
        return false;
    }
    
    
    
    
}
