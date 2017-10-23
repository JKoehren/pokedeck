/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg;

import java.util.HashMap;
import upmc.pcg.ui.GameUI;

/**
 *
 * @author Laura
 */
public class Energy extends Card{ 
   
    
    public Energy(){
        this.map_card.put("card_type", this.type="ENERGY");
        this.energy_type=set_energy();
        report();
    }
    
    public String toString(){
        String str;
        str=("ENERGY : "+this.energy_type);
        return str;
    }
    
    
}
