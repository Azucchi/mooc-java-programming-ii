
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
public class VehicleRegistry {
    private HashMap<LicensePlate, String> registry;
    
    public VehicleRegistry(){
        this.registry = new HashMap<>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner){
        if(this.registry.keySet().contains(licensePlate)){
            return false;
        }
        
        this.registry.put(licensePlate, owner);
        return true;
    }
    
    public String get (LicensePlate licensePlate){
        return registry.getOrDefault(licensePlate, null);
    }
    
    public boolean remove(LicensePlate licensePlate){
        if(registry.containsKey(licensePlate)){
            registry.remove(licensePlate);
            return true;
        } else {
            return false;
        }
    }
    
    public void printLicensePlates(){
        for (LicensePlate each: this.registry.keySet()){
            System.out.println(each);
        }
    }
    
    public void printOwners(){
        ArrayList<String> owners = new ArrayList<>();
        
        for(String each: this.registry.values()){
            if(!owners.contains(each)){
                System.out.println(each);
                owners.add(each);
            }
        }
    }
    
    
}
