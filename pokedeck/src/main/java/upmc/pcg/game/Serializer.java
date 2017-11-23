package upmc.pcg.game;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;


public class Serializer {
	
	ObjectMapper mapper = new ObjectMapper();

	public Serializer() {
	}
	
	@SuppressWarnings("unchecked")
	public void save_deck(Player player) {
		
		String folder = player.toString() + "_" + player.get_password();
		File file = new File(System.getProperty( "user.dir" ) + "/data/" + folder);
		if (!file.exists()) file.mkdir();
		
		String json = "";
		
		ArrayList<Card> deck = player.get_deck().get_cards();
		
		for ( int i = 0, n = deck.size() ; i < n ; i++ ) {
			HashMap<String,String> deckOut = player.get_deck().get_cards().get(i).get_map_card(); 
			
			try {
				
				json = mapper.writeValueAsString(deckOut);
				
				mapper.writeValue(new File(file.getAbsolutePath() + "/" + i +".json"), json);
				
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList upload_deck(Player player) {
		
		File file = new File(System.getProperty( "user.dir" ) + "/data/" + player.toString() + "_" +player.get_password());
		
		ArrayList deckIn = new ArrayList<>();
		
		for (int i = 0, n = file.listFiles().length ; i < n ; i++) {
		
			try {
				
				deckIn.add( mapper.readValue(new File(file.getAbsolutePath() + "/" + i + ".json"), new TypeReference<HashMap>(){}) );
				
			}catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
		return deckIn;
	}
	
}
