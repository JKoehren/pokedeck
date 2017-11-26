package upmc.pcg.game;


import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public interface Serializer {
	
	public static void saveDeck( Player p ) {
		
		String uri = "data/" + p.toString() + ".json";
		Deck toSave = p.get_deck();
		
		try ( Writer writer = new FileWriter(uri) ) {
			Gson gson = new GsonBuilder().create();
			gson.toJson(toSave, writer);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void uploadDeck( Player p ) {
		try(Reader reader = new FileReader("data/" + p.toString() + ".json")){
			Gson gson = new GsonBuilder().create();
			Deck toUp = gson.fromJson(reader, Deck.class);
			p.set_deck(toUp);
			System.out.println("Le deck de "+p+" a bien été chargé !");
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
//	ObjectMapper mapper = new ObjectMapper();
	
	
	
	
	
	
	
	
/*	@SuppressWarnings("unchecked")
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
	}*/
	
}
