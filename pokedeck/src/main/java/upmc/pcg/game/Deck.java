package upmc.pcg.game;

import java.util.ArrayList;

/**
 * @author Laura
 */

public class Deck {
	
    protected ArrayList<Card> cards = new ArrayList<Card>();
   
    public void create_card( String card_type ) {
    	
        Card c=null;
        
        switch( card_type ){
            case "ENERGY":
                c = new Energy();
                break;
            case "POKEMON":
                c = new Pokemon();
                break;
            case "TRAINER":
                c = new Trainer();
                break;
        }
        c.settings();
        
        cards.add( c );
    }
    
    public ArrayList<Card> get_cards() {
        return this.cards;
    }
    
    public void set_cards(ArrayList<Card> setCards) {
    	this.cards = setCards;
    }
}