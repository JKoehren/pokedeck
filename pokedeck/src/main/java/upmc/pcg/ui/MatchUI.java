/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.ui;

import java.util.ArrayList;
import upmc.pcg.game.Card;
import upmc.pcg.game.Player;
import static upmc.pcg.ui.MenuUI.print;

/**
 *
 * @author Laura
 */
public class MatchUI {
    public Player askOpponent(ArrayList<Player> allPlayers, Player currentPlayer) {
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
    
    public void start(ArrayList<Player> p){
        print("*************************************** FIGHT *****************************************");
        print("---------------------------------------------------------------------------------------");
        print("                          "+p.get(0)+"  VS  "+p.get(1)+"                                ");
        print("---------------------------------------------------------------------------------------");
    }
    public void prepareArenaReport(Player p){
        print("");
        print(p+" shuffle his deck.");
        print(p+" draw his hand.");
    }
    public void noPokemon(Player p){
        print("");
        print(p+" has no pokemon in his hand !");
    }
    public Card chooseActivePokemon(Player p){
        ArrayList<Card> hand=p.getHand();
        print("");
        print(p+", which pokemon do you wanna activate?");
        printHand(hand);
        int choice = TestsUI.testInt( -1, 1, p.getHand().size() );
        return hand.get(choice-1);
    }
    
    public void printHand(ArrayList<Card> hand){

        for(int i=0; i<hand.size(); i++){
            print((i+1)+" - "+hand.get(i));
        }
    }

    public void announceActivation(Card activePokemon, Player p) {
        print(activePokemon +" is activated !");
        printHand(p.getHand());
    }
}
