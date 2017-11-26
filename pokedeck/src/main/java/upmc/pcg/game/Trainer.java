package upmc.pcg.game;

/**
 * @author Laura
 */

public class Trainer extends Card {
	
	public Trainer() {
		
        this.map_card.put( "card_type", this.type = "TRAINER" );
        this.name = set_name();
        this.description = set_description();
        report();
    }
	
    public String toString() {
        return "TRAINER : " + this.name;
    }
    
    public void set_argument( String argument ) {
    	
        switch ( argument ) {
            case "name" :
                this.name = set_name();
                break;
            case "description" :
                this.description = set_description();
                break; 
        }
    }
}