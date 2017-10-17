/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;

import java.util.HashMap;
import upmc.pcg.ui.GameUI;

/**
 *
 * @author Laura
 */
public class Energy extends Card{ 
    String type;
    private static String energies[]={"grass", "fire", "water", "lightning", "psychic", "fighting", "darkness", "metal", "fairy", "dragon", "colorless"};
    
    public Energy(){
        this.type=GameUI.ask_energy_type(energies);
        this.map_card.put("energy_type", this.type);
        this.map_card.put("card_type", "ENERGY");
        GameUI.report_creation_card(this.toString());
    }
    
    public String toString(){
        String str;
        str=("ENERGY : "+this.type);
        return str;
    }
    
    
}
