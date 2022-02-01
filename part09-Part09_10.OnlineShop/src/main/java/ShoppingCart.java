
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
public class ShoppingCart {
    
    private List<Item> cart;
    
    public ShoppingCart(){
        this.cart = new ArrayList<>();
    }
    
    public void add(String product, int price){
        
        Item addItem = new Item(product,price);        
        int index = this.cart.indexOf(addItem);
        
        if(index > -1){
            this.cart.get(index).increaseQuantity();
        } else {
            this.cart.add(addItem);
        }        
        
    }
    
    public int price(){
        int price = 0;
        for (Item each:cart){
            price += each.price();
        }
        
        return price;
    }
    
    public void print(){
        for(Item each:cart){
            System.out.println(each);
        }
    }
    
    
}
