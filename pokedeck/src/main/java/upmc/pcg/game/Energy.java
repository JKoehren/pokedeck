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
   
    
    public Energy(){
        this.map_card.put("card_type", "ENERGY");
    }
    
    public String toString(){
        String str;
        str=("ENERGY : "+this.type);
        return str;
    }
    
    
}
