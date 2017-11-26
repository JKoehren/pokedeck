package upmc.pcg.game;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author licence
 */

public class Pokemon extends Card {
    
    private ArrayList attacks;
    private int hp;
    private String weakness;
    private String resistance;
    private HashMap retreat_cost;
    
    public Pokemon() {
    	
        this.map_card.put( "card_type", this.type = "POKEMON" );
        this.name = set_name();
        this.energy_type = set_energy();
        this.hp = set_hp();
        this.attacks = set_attacks();
        this.weakness = set_weakness();
        this.resistance = set_resistance();
        this.retreat_cost = set_retreat();
        this.description = set_description();
        report();
    }
    
    public String toString() {
        return "POKEMON : "+this.name;
    }
    
    public void set_argument( String argument ) {
    	System.out.println(argument);
        switch ( argument ){
            case "energy" :
                this.energy_type = set_energy();
                break;
            case "name" :
                this.name = set_name();
                break;
            case "description" :
                this.description = set_description();
                break;
            case "HP" :
                this.hp = set_hp();
                break;
            case "attacks" :
                this.attacks = set_attacks();
                break;
            case "weakness" :
                this.weakness = set_weakness();
                break;
            case "resistance" :
                this.resistance = set_resistance();
                break;
            case "retreat" :
                this.retreat_cost = set_retreat();
                break;
        }
    }
}