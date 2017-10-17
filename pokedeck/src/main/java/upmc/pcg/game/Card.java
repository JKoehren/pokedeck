/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;
import java.util.HashMap;

/**
 *
 * @author Laura
 */
public class Card {
    protected HashMap map_card=set_map_card();
    
    private HashMap set_map_card(){
        HashMap hm=new HashMap();
        hm.put("card_type", "");
        hm.put("energy_type", "");
        return hm;
    }
    
    
}
