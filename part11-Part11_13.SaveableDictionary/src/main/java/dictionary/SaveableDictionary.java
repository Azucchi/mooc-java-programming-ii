/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author reroy
 */
public class SaveableDictionary {
    
    private HashMap<String, String> dictionary;
    private String filename;
    private HashMap<String, String> reverseDictionary;
    
    public SaveableDictionary(){
        this.dictionary = new HashMap<>();
        this.reverseDictionary = new HashMap<>();
    }
    
    public SaveableDictionary (String file){
        this.filename = file;
        this.dictionary = new HashMap<>();
        this.reverseDictionary = new HashMap<>();
        
    }
    
    public void add(String words, String translation){
        if(this.dictionary.keySet().contains(words) || this.reverseDictionary.keySet().contains(translation)){
            
        } else{
            this.dictionary.put(words, translation);
            this.reverseDictionary.put(translation, words);
        }
    }
    
    public String translate (String word){
        if(this.dictionary.containsKey(word)){            
            return this.dictionary.get(word);            
        } else if(this.reverseDictionary.containsKey(word)){
            return this.reverseDictionary.get(word);
        } else return null;
    }
    
    public void delete(String word){

        this.dictionary.remove(word);
        this.dictionary.values().remove(word);
        this.reverseDictionary.remove(word);
        this.reverseDictionary.values().remove(word);
    }
    
    public boolean load(){
        try{
            
            Scanner scanner = new Scanner(Paths.get(this.filename));
            while(scanner.hasNextLine()){
                String row = scanner.nextLine();
                String[] parts = row.split(":");
                this.dictionary.put(parts[0], parts[1]);
                this.reverseDictionary.put(parts[1], parts[0]);
            }         
            return true;
            
        } catch (Exception e){
            System.out.println("eh");
            return false;
        }
    }
    
    public boolean save(){
        
        try {            
            PrintWriter writer = new PrintWriter(this.filename);
            for(String each: this.dictionary.keySet()){
                writer.println(each + ":" + this.dictionary.get(each));
             
            }
            writer.close();
            return true;
            
        } catch (Exception e){
            System.out.println("oops");
            return false;
        }
        
    }
    
}
