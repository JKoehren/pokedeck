package upmc.pcg.game;
import upmc.pcg.ui.GameUI;

import java.util.*;

public class Game implements Serializer {

	ArrayList<Player> players;

	public Game() {
		players = new ArrayList<>();
	}

	public void initialize( ArrayList<String> players_name ) {

		for( String name : players_name ) {
			
			Player user = new Player( name );
			
			if (! Serializer.uploadDeck( user )) {
				
				String starterDeck = GameUI.askIfStarterDeck( user );
                if(!starterDeck.equals("")) Serializer.uploadDeck( user, starterDeck );
			}
			
			this.players.add( user );
		}
	}
	
        public int getPlayersNumber(){
            return players.size();
        }
        public ArrayList getAllPlayers(){
            return players;
        }
	public Player getPlayer() {
		
		Player p = null;
		
		for( Player cursor : this.players ) {
			
			if ( cursor.get_isPlaying() ) {
				p=cursor;
			}
		}
		
		if( p != null ) {
			return p;
		} else {
			throw new UnsupportedOperationException( "Not supported yet." );
		}
	}
	
	public Player nextPlayer() {
		
		Player current = getPlayer();
 
		int next = this.players.indexOf( current ) + 1;
		
		if( next >= this.players.size() ) {
			next = 0;
		}

		Player nextPlayer = this.players.get( next );
		current.play( false );
		nextPlayer.play( true );
		return nextPlayer;
	}

	public ArrayList<Card> getActualDeck() {
		return this.getPlayer().get_deck().get_cards();
	}

	public void setDecks() {
		
		for( Player p : this.players ){
			Serializer.saveDeck( p );
		}
	}

        public void startMatch() {
            Match match=new Match(this);   
        }

}