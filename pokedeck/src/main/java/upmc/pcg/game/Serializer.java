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
		
		try ( Writer writer = new FileWriter( uri ) ) {
			
			Gson gson = new GsonBuilder().create();
			gson.toJson( toSave, writer );
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void uploadDeck( Player p ) {
		
		String uri = "data/" + p.toString() + ".json";
		
		try( Reader reader = new FileReader( uri ) ) {
			
			Gson gson = new GsonBuilder().create();
			Deck toUp = gson.fromJson( reader, Deck.class );
			p.set_deck( toUp );
			System.out.println( "Le deck de " + p + " a bien été chargé !" );
			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}