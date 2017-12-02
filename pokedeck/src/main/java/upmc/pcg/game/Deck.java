package upmc.pcg.game;

import java.util.ArrayList;
import static java.util.Collections.shuffle;

/**
 * @author Laura
 */

public class Deck {
	
    protected ArrayList<Card> cards = new ArrayList<Card>();
   
    public void createCard( String card_type ) {
    	
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
    public void shuffleCards(){
        shuffle(this.cards);
    }
    public ArrayList<Card> getCards() {
        return this.cards;
    }
    public Card getOneCard(int index) {
        return this.cards.get(index);
    }
    public void removeCard(int index){
        this.cards.remove(index);
    }

    public void setCards(ArrayList<Card> setCards) {
    	this.cards = setCards;
    }
}