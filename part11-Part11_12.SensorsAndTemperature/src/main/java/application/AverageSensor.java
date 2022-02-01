/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author reroy
 */
public class AverageSensor implements Sensor{
    
    private List<Sensor> sensors;
    private List<Integer> readings;
    
    public AverageSensor(){
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }
    
    public void addSensor (Sensor toAdd){
        this.sensors.add(toAdd);
    }
    

    @Override
    public boolean isOn() {
        boolean returned = false;
        for(Sensor each: this.sensors){
            if(each.isOn()){
                returned = true;
                break;
            }
        }
        return returned;
    }

    @Override
    public void setOn() {
        this.sensors.stream()
                .forEach(sensor -> sensor.setOn());
    }

    @Override
    public void setOff() {
        this.sensors.stream()
                .forEach(sensor -> sensor.setOff());
    }

    @Override
    public int read() {
        try{
            
            int sum = this.sensors.stream()
                    .mapToInt(sensor -> sensor.read())
                    .sum();
            sum = sum/this.sensors.size();
            this.readings.add(sum);
            return sum;
                    
            
        } catch (Exception e){
            throw new IllegalStateException ("bruh");
        }
    }
    
    public List<Integer> readings(){
                    
        return this.readings;
    }
    
    
    
}
