/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;

import java.util.ArrayList;
import upmc.pcg.ui.FightUI;

/**
 *
 * @author Laura
 */
class Match {
    Game game;
    FightUI fightUI;
    ArrayList<Player> fighters=new ArrayList();
    
    public Match(Game game){
        this.game=game;
        this.fightUI=new FightUI();
        this.fighters=choseFighters();
        
        fightUI.start(fighters);
        
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
}
