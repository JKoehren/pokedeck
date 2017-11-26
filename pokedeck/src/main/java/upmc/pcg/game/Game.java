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
                        String starterDeck = GameUI.ask_if_starter_deck( user );
                        if(!starterDeck.equals("")){
                            Serializer.uploadDeck( user, starterDeck );
                        }else{
                           Serializer.uploadDeck( user ); 
                        }
			
			this.players.add( user );
		}
	}
	
        public int getPlayersNumber(){
            return players.size();
        }
	public Player get_player() {
		
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
	
	public Player next_player() {
		
		Player current = get_player();
 
		int next = this.players.indexOf( current ) + 1;
		
		if( next >= this.players.size() ) {
			next = 0;
		}

		Player nextPlayer = this.players.get( next );
		current.play( false );
		nextPlayer.play( true );
		return nextPlayer;
	}

	public ArrayList<Card> get_actualDeck() {
		return this.get_player().get_deck().get_cards();
	}

	public void set_decks() {
		
		for( Player p : players ){
			Serializer.saveDeck( p );
		}
	}
}