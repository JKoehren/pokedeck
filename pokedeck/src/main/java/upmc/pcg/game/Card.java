/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;
import java.util.ArrayList;
import java.util.HashMap;
import upmc.pcg.ui.CreationCardUI;
import upmc.pcg.ui.GameUI;


/**
 *
 * @author Laura
 */
public class Card {
    protected HashMap map_card = set_map_card();
    protected String type, name, energy_type, description;
    private static HashMap<Integer,String> energies = new HashMap<Integer, String>(){
    	{
	        put(1, "grass");
	        put(2, "fire");
	        put(3, "water");
	        put(4, "lightning");
	        put(5, "psychic");
	        put(6, "fighting");
	        put(7, "darkness");
	        put(8, "metal");
	        put(9, "fairy");
	        put(10, "dragon");
	        put(11, "colorless");
    	}
    };

    protected String set_energy(){
        String energy=CreationCardUI.ask_energy_type(energies, this.type);
        this.map_card.put("energy_type", energy);
        return energy;
    }
    
    protected String set_name(){
        String name=CreationCardUI.ask_name(this.type);
        this.map_card.put("name", name);
        return name;
    }
    
    protected ArrayList<Attack> set_attacks(){
        ArrayList<Attack> attacks=new ArrayList();
        boolean add_attack=true;
        int i=1;
        do{
            String name=CreationCardUI.ask_attack_name();
            int strenght=CreationCardUI.ask_attack_strenght();
            ArrayList energy_needed=CreationCardUI.ask_attack_energy(energies);
            
            Attack a=new Attack(name, strenght, energy_needed);
            attacks.add(a);
            
            if(i==1){
                this.map_card.put("attack_number", 2);
                add_attack=CreationCardUI.ask_if_add_attack();
            }else{
                add_attack=false;
            }
            this.map_card.put("attack"+i+"_name", a.get_name());
            this.map_card.put("attack"+i+"_strenght", a.get_strenght());
            this.map_card.put("attack"+i+"_energy_needed", a.get_energy_needed());
            i++;
        }while(add_attack);
        
        return attacks;
    }
    
    protected int set_hp(){
        int hp=CreationCardUI.ask_hp();
        this.map_card.put("HP", hp+"");
        return hp;
    }
    
    protected String set_weakness(){
        String weakness=CreationCardUI.ask_weakness(energies);
        this.map_card.put("weakness", weakness);
        return weakness;
    }
    
    protected String set_resistance(){
        String resistance=CreationCardUI.ask_resistance(energies);
        this.map_card.put("resistance", resistance);
        return resistance;
    }
    
    protected HashMap set_retreat(){
        HashMap retreat=CreationCardUI.ask_retreat(energies);
        this.map_card.put("retreat_cost", retreat.get("number")+" "+retreat.get("energy"));
        return retreat;
    }
    protected String set_description(){
        String description=CreationCardUI.ask_description(this.type);
        this.map_card.put("description", description);
        return description;
    }
    protected void report(){
        GameUI.report_creation_card(this.toString());
    }
    private HashMap<String, String> set_map_card(){
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("card_type", "");
        hm.put("energy_type", "");
        hm.put("name", "");
        hm.put("HP", "");
        hm.put("attack1_name", "");
        hm.put("attack1_strenght", "");
        hm.put("attack1_energy_needed", "");
        hm.put("attack2_name", "");
        hm.put("attack2_strenght", "");
        hm.put("attack2_energy_needed", "");
        hm.put("weakness", "");
        hm.put("resistance", "");
        hm.put("retreat_cost", "");
        hm.put("description", "");
        return hm;
    }
    
    public HashMap get_map_card(){
        return this.map_card;
    }
    
    public String get_type_card() {
    	return (String) this.map_card.get("card_type");
    }
    public void set_argument(String argument) {

    }
}
