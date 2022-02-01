
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
public class TodoList {
    
    private ArrayList<String> tasks;
    
    public TodoList(){
        tasks = new ArrayList<>();
    }
    
    public void add(String task){
        tasks.add(task);
    }
    
    public void print(){
        for (int i = 1; i <= tasks.size(); i++){
            System.out.println(i + ": " + tasks.get(i-1));
        }
    }
    
    public void remove(int number){
        tasks.remove(number-1);
    }
    
}
