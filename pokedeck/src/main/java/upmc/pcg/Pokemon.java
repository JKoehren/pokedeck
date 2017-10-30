/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author licence
 */
public class Pokemon extends Card{
    
	
	private final ArrayList attacks;
    private int hp;
    private final String weakness;
    private final String resistance;
    private final HashMap retreat_cost;
    
    public Pokemon(){
        this.map_card.put("card_type", this.type="POKEMON");
        this.name=set_name();
        this.energy_type=set_energy();
        this.hp=set_hp();
        this.attacks=set_attacks();
        this.weakness=set_weakness();
        this.resistance=set_resistance();
        this.retreat_cost=set_retreat();
        this.description=set_description();
        
        report();
    }
    
    public String toString(){
        String str;
        str=("POKEMON : "+this.name);
        return str;
    }
}
