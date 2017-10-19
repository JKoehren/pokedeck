/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;
import java.util.ArrayList;
import java.util.HashMap;
import upmc.pcg.ui.GameUI;

/**
 *
 * @author Laura
 */
public class Card {
    protected HashMap map_card=set_map_card();
    String type;
    private static String energies[]={"grass", "fire", "water", "lightning", "psychic", "fighting", "darkness", "metal", "fairy", "dragon", "colorless"};
    private static String weekness[][]={{"fire"},{"lightning"}, {"water"}, {"lightning", "grass"},{"darkness"},{"psychic"},{"fighting"},{"fighting, fire"},{"metal"},{""},{"combat"}};
    private static ArrayList retreat;
    
    public Card(){
        this.type=GameUI.ask_energy_type(energies);
        this.map_card.put("energy_type", this.type);
        GameUI.report_creation_card(this.toString());
    }
    private HashMap set_map_card(){
        HashMap hm=new HashMap();
        hm.put("card_type", "");
        hm.put("energy_type", "");
        hm.put("name", "");
        hm.put("HP", "");
        hm.put("attacks", "");
        hm.put("weekness", "");
        hm.put("retreat", "");
        return hm;
    }
    
    
}
