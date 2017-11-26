package upmc.pcg.game;

/**
 * @author Laura
 */

public class Player {
	
    private String name;
    private boolean isPlaying;
    private Deck deck = new Deck();
    
    public Player() {
    	
        this.name = "Player 1";
        this.isPlaying = true;
    }
    
    public Player( String name ) {
    	
        this.name = name;
        this.isPlaying = true;
    }
    
    public void add_card( String card_type ) {
        this.deck.create_card( card_type );
    }
    
    public Deck get_deck() {
        return this.deck;
    }
    
    public void set_deck( Deck up ) {
    	this.deck = up;
    }

    public String toString() {
        return this.name;
    }
    
    public void play( boolean inOut ) {
        this.isPlaying = inOut;
    }
    
    public boolean get_isPlaying() {
        return this.isPlaying;
    }
}