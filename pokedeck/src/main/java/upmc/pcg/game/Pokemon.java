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
    
    public Pokemon() {}
    
    public void settings() {
    	
        this.map_card.put( "card_type", this.type = "POKEMON" );
        this.name = setName();
        this.energy_type = setEnergy();
        this.hp = setHP();
        this.attacks = setAttacks();
        this.weakness = setWeakness();
        this.resistance = setResistance();
        this.retreat_cost = setRetreat();
        this.description = setDescription();
        report();
    }
    
    public String toString() {
        return "POKEMON : "+this.name;
    }
    
    public void setArgument( String argument ) {
    	System.out.println(argument);
        switch ( argument ){
            case "energy" :
                this.energy_type = setEnergy();
                break;
            case "name" :
                this.name = setName();
                break;
            case "description" :
                this.description = setDescription();
                break;
            case "HP" :
                this.hp = setHP();
                break;
            case "attacks" :
                this.attacks = setAttacks();
                break;
            case "weakness" :
                this.weakness = setWeakness();
                break;
            case "resistance" :
                this.resistance = setResistance();
                break;
            case "retreat" :
                this.retreat_cost = setRetreat();
                break;
        }
    }
}