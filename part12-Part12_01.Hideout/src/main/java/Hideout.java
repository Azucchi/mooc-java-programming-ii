
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
public class Hideout<T> {
    
    private List<T> a;
    
    public Hideout(){
        this.a = new ArrayList<>();
    }
    
    public void putIntoHideout(T toHide){
        if(this.a.size() == 1){
            this.a.clear();
            this.a.add(toHide);
        } else {
            this.a.add(toHide);
        }
    }
    
    public T takeFromHideout(){
        if(this.a.size() == 1){
            T t = this.a.get(0);
            this.a.clear();
            return t;            
        } else {
            return null;
        }
    }
    
    public boolean isInHideout(){
        return (this.a.size() == 1);
    }
    
}
