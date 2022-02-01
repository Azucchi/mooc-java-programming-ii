/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reroy
 */
public abstract class Animal {
    
    protected String name;
    
    public Animal (String name){
        this.name = name;
    }
    
    public void sleep(){
        System.out.println(this.name+ "sleeps");
    }
    
    public void eat(){
        System.out.println(this.name + "eats");
    }
    
    public String getName(){
        return this.name;
    }
    
}
