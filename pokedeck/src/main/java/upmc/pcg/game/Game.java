// Copyright 2017 Pierre Talbot (IRCAM)

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//   http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package upmc.pcg.game;

import java.util.*;

public class Game {
  ArrayList<Player> players;
  
  public Game() {
      players=new ArrayList();
  }
  public void initialize(ArrayList<String> players_name) {
      for(String name : players_name){
          this.players.add(new Player(name));
      }
  }
  public void play() {
    //...
  }
  public Player get_player(){
      Player p = null;
      for(Player cursor : this.players){
          if(cursor.get_isPlaying()){
              p=cursor;
          }
      }
      if(p!=null){
          return p;
      }else{
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }
      
  }
  public Player next_player(){
      Player current=get_player();
      int next = this.players.indexOf(current)+1;
      if(next >= this.players.size()){
          next=0;
      }
      
      Player nextPlayer=this.players.get(next);
      
      current.play(false);
      nextPlayer.play(true);
      return nextPlayer;
  }
  
  public ArrayList<Card> get_actualDeck(){
	  
	  return this.get_player().get_deck().get_cards();
	  
  }

}
