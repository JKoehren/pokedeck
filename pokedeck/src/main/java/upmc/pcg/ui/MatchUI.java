/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.ui;

import java.util.ArrayList;
import upmc.pcg.game.Player;
import static upmc.pcg.ui.MenuUI.print;

/**
 *
 * @author Laura
 */
public class FightUI {
    public static Player askOpponent(ArrayList<Player> allPlayers, Player currentPlayer) {
        print("Who do you want to challenge ?");
        int i;
        for(i=0; i<allPlayers.size(); i++){
            if(!allPlayers.get(i).equals(currentPlayer)){
                print((i+1)+"- "+allPlayers.get(i));
            }
        }
        int choice = TestsUI.testInt(-1, 1, i);
        return allPlayers.get(choice-1); 
    }
    
    public static void start(ArrayList<Player> p){
        print("*************************************** FIGHT *****************************************");
        print("---------------------------------------------------------------------------------------");
        print("                          "+p.get(0)+"  VS  "+p.get(1)+"                                ");
        print("---------------------------------------------------------------------------------------");
    }
}
