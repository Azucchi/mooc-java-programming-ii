
import java.util.ArrayList;
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
public class StorageFacility {
    
    private HashMap<String, ArrayList<String>> storage;
    
    public StorageFacility(){
        this.storage = new HashMap<>();
    }
    
    public void add(String unit, String item){
        this.storage.putIfAbsent(unit, new ArrayList<>());
        
        this.storage.get(unit).add(item);        
    }
    
    public void remove(String storageUnit, String item){
        this.storage.get(storageUnit).remove(item);
        if(this.storage.get(storageUnit).size() == 0){
            this.storage.remove(storageUnit);
        }
    }
    
    public ArrayList<String> contents(String storageUnit){
        if(!this.storage.containsKey(storageUnit)){
            return new ArrayList<>();
        }
        
        return storage.get(storageUnit);
    }
    
    public ArrayList<String> storageUnits(){
        ArrayList<String> storages = new ArrayList<>();
        for (String storageNames: this.storage.keySet()){
            storages.add(storageNames);
        }
        
        return storages;
    }
    
    
    
    
}
