
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reroy
 */
public class IOU {
    
    private HashMap<String, Double> debts;
    
    public IOU(){
        debts = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount){
        this.debts.put(toWhom, amount);
    }
    
    public double howMuchDoIOweTo(String toWhom){
        return this.debts.getOrDefault(toWhom, 1.0 * 0);
    }
    
}
