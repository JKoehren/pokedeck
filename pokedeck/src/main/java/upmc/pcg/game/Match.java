/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;

import java.util.ArrayList;
import java.util.Iterator;
import upmc.pcg.ui.MatchUI;

/**
 *
 * @author Laura
 */
class Match {
    Game game;
    MatchUI fightUI;
    ArrayList<Player> fighters=new ArrayList();
    
    public Match(Game game){
        this.game=game;
        this.fightUI=new MatchUI();
        this.fighters=choseFighters();
        
        start();
        
    }
    private ArrayList choseFighters(){
        ArrayList<Player> fighters=new ArrayList(); 
        fighters.add(this.game.getPlayer());
        if(this.game.getPlayersNumber()>2){
            fighters.add(fightUI.askOpponent(this.game.getAllPlayers(), this.game.getPlayer()));
        }else{
            fighters.add(this.game.nextPlayer());
        }
        return fighters;
    }

    private void start() {
        fightUI.start(fighters);
        prepareArena();
    }

    private void prepareArena() {
       playersGetHand();
       playersChoosePokemons();
    }
    
    private void playersGetHand(){
        for(int i=0; i<2; i++){
            Player p=fighters.get(i);
            boolean isPokemon=false;
            while(!isPokemon){
                p.getDeck().shuffleCards();
                isPokemon=p.drawHand(7); // 7 is the numbers of cards you have to draw to initialize your deck
                if(!isPokemon){
                    p.cancelDrawHand();
                    fightUI.noPokemon(p);
                }
            }
            
            fightUI.prepareArenaReport(p);
       }
    }

    private void playersChoosePokemons() {
        for(int i=0; i<2; i++){
            Player p=fighters.get(i);
            Card activePokemon=p.activePokemon( fightUI.chooseActivePokemon(p), "hand");
            fightUI.announceActivation(activePokemon, p);
            
        }
    }
}
