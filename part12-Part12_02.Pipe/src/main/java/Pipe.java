
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reroy
 */
public class Pipe<T> {
    
    private List<T> pipe;
    
    public Pipe(){
        this.pipe = new ArrayList<>();
    }
    
    public void putIntoPipe(T value){
        this.pipe.add(value);
    }
    
    public T takeFromPipe(){
        if(this.pipe.isEmpty()){
            return null;
        } else {
            T valueToReturn = this.pipe.get(0);
            this.pipe.remove(this.pipe.get(0));
            return valueToReturn;
        }
    }
    
    public boolean isInPipe(){
        return !this.pipe.isEmpty();
    }
    
    
    
}
