/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg;

/**
 *
 * @author Laura
 */
public class Energy extends Card{ 
   
    
    @SuppressWarnings("unchecked")
    public Energy(){
        this.map_card.put("card_type", this.type="ENERGY");
        this.energy_type=set_energy();
        report();
    }
    
    @Override
    public String toString(){
        String str;
        str=("ENERGY : "+this.energy_type);
        return str;
    }
    @Override
    public void set_argument(String argument) {
        switch (argument){
            case "energy" :
                this.energy_type=set_energy();
                break;
        }
    }
    
    
}
