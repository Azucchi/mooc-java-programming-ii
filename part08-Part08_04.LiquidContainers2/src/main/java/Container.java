/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reroy
 */
public class Container {
    
    public int content;
    
    public Container(){
        this.content = 0;
    }
    
    public int contains(){
        return this.content;
    }
    
    public void add (int amount){
        if(amount > 0){
            this.content += amount;
        }
        if (this.content > 100){
            this.content = 100;
        }
    }
    
    public void remove(int amount){
        if(amount > 0){
            this.content -= amount;
            
        }
        
        if (this.content < 0){
            this.content = 0;
        }
    }
    
    @Override
    public String toString(){
        return this.content + "/100";
    }
    
    
    
}
