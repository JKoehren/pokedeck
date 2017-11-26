/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Laura
 */
public class Deck {
    protected ArrayList<Card> cards=new ArrayList<Card>();
    
    
    public void create_card(String card_type){
        Card c=null;
        switch(card_type){
            case "ENERGY":
                c=new Energy();
                break;
            case "POKEMON":
                c=new Pokemon();
                break;
            case "TRAINER":
                c=new Trainer();
                break;
        }
        cards.add(c);
    }
    public ArrayList<Card> get_cards(){
        return this.cards;
    }
            
}
