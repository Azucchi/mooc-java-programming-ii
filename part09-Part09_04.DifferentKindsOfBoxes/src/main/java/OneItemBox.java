
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
public class OneItemBox extends Box{
    
    private ArrayList<Item> content;
    
    public OneItemBox(){
        this.content = new ArrayList<>();
    }
    
    public void add(Item item){
        if(this.content.size() == 0){
            this.content.add(item);
        }
    }
    
    public boolean isInBox(Item item){
        return this.content.contains(item);
    }
    
}
