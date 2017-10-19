/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;

import java.util.ArrayList;

/**
 *
 * @author licence
 */
public class Pokemon extends Card{
    private String name;
    private ArrayList attacks;
    private int hp;
    
    
    public Pokemon(){
        this.map_card.put("card_type", "POKEMON");
    }
    
    public String toString(){
        String str;
        str=("POKEMON : "+this.type);
        return str;
    }
}
