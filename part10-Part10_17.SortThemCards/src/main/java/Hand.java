
import java.util.ArrayList;
import java.util.Collections;
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
public class Hand implements Comparable<Hand>{
    
    private List<Card> hand;
    
    public Hand(){
        this.hand = new ArrayList<>();
    }
    
    public void add(Card card){
        this.hand.add(card);
    }
    
    public void print(){
        this.hand.stream()
                .forEach(card -> System.out.println(card));
    }
    
    public void sort(){
        this.hand.stream()
                .sorted((p1, p2) -> 
                {return p1.compareTo(p2);})
                .forEach(card -> System.out.println(card));                
    }
    
    private int handValue(){
        return this.hand.stream()
                .mapToInt(card -> card.getValue())
                .sum();
    }

    @Override
    public int compareTo(Hand hand) {        
        return this.handValue() - hand.handValue();        
    }
    
    public void sortBySuit(){
        Collections.sort(this.hand, new BySuitInValueOrder());
   //     Collections.sort(this.hand, (c1, c2) -> c1.getSuit().ordinal() - c2.getSuit().ordinal());
    }

}
