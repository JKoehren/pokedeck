package upmc.pcg.game;

/**
 * @author Laura
 */

public class Energy extends Card { 
    
    public Energy() {
    	
        this.map_card.put( "card_type", this.type = "ENERGY" );
        this.energy_type = set_energy();
        report();
    }
    
    @Override
    public String toString() {
        return "ENERGY : " + this.energy_type;
    }
    
    public void set_argument( String argument ) {
    	
        switch ( argument ) {
            case "energy" :
                this.energy_type = set_energy();
                break;
        }
    }
}