package upmc.pcg.game;

import java.util.ArrayList;

/**
 * @author Laura
 */

public class Player {
	
    private String name;
    private boolean isPlaying;
    private Deck deck = new Deck();
    private ArrayList<Card> hand, bench;
    private Card activePokemon;

    
    public Player() {
        this.name = "Player 1";
        this.hand=new ArrayList();
        this.isPlaying = true;
    }
    
    public Player( String name ) {
    	
        this.name = name;
        this.isPlaying = true;
        this.hand=new ArrayList();
    }
    
    public void add_card( String card_type ) {
        this.deck.createCard( card_type );
    }
    
    public boolean drawHand(int numCardsToAdd) {
        boolean isPokemon=false;
        for(int i=0; i<numCardsToAdd; i++){
            Card c=this.deck.getOneCard(0);
            if(c.getTypeCard().equals("POKEMON")){
                isPokemon=true;
            }
            this.deck.removeCard(0);
            this.hand.add(c);
        }
        return isPokemon;
    }
    public void cancelDrawHand(){
        for(int i=0; i<this.hand.size(); i++){
            this.deck.getCards().add(this.hand.get(0));
            this.hand.remove(0);
        }
    }
    
    public Deck getDeck() {
        return this.deck;
    }
    
    public ArrayList<Card> getHand(){
        return this.hand;
    }
    public Card activePokemon(Card pokemon, String from){
        this.activePokemon=pokemon;
        switch(from){
            case "hand":
                this.hand.remove(this.hand.indexOf(pokemon));
                break;
            case "bench":
                this.bench.remove(this.bench.indexOf(pokemon));
                break;
            default :
                throw new UnsupportedOperationException("Problem : the source is wrong"); 
               
        }
        return this.activePokemon;
    }
    
    public void setDeck( Deck up ) {
    	this.deck = up;
    }

    public String toString() {
        return this.name;
    }
    
    public void play( boolean inOut ) {
        this.isPlaying = inOut;
    }
    
    public boolean getIsPlaying() {
        return this.isPlaying;
    }



    
}