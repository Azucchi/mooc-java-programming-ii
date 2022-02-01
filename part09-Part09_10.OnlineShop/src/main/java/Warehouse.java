
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reroy
 */
public class Warehouse {
    
    private Map<String, Integer> products;
    private Map<String, Integer> quantities;
    
    public Warehouse(){
        this.products = new HashMap<>();
        this.quantities = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock){
        products.put(product, price);
        quantities.put(product, stock);
    }
    
    public int price(String product){
        if(!products.containsKey(product)){
            return -99;
        }
        return products.get(product);
    }
    
    public int stock(String product){
        if(!quantities.containsKey(product)){
            return 0;
        }
        
        return quantities.get(product);
    }
    
    public boolean take(String product){
        if(!quantities.containsKey(product) || quantities.get(product) == 0){
            return false;
        }
        int stock = quantities.get(product);
        stock--;
        quantities.put(product, stock);
        return true;
    }
    
    public Set<String> products(){
        return quantities.keySet();
    }
    
    
    
    
    
}
