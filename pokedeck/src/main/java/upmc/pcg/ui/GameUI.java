// Copyright 2017 Pierre Talbot (IRCAM)

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//     http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package upmc.pcg.ui;

import java.util.*;
import upmc.pcg.Card;
import upmc.pcg.game.Game;
import upmc.pcg.game.Player;
import upmc.pcg.game.Serializer;

public class GameUI extends Serializer implements TestsUI {
	
	private final Game game = new Game();
//	private final CreationCardUI creationCard = new CreationCardUI();
 
	private boolean goOn = true;
  

	public void start() {
	    char login = print_welcome_msg();
	    
	    ArrayList<String> names = ask_players_names();
	    game.initialize(names);
	    
	    game.get_player().set_password(ask_password(login));
	    
	    while(goOn){
	        menu();
	    }
	    game.play();
	    print_goodbye_msg();
	}

	private ArrayList<String> ask_players_names() {
        String player_name = "";
        print("What's your name ? (max 20 char)");

        do {
        	 player_name = TestsUI.test_string( 20 );
        	if (player_name == "Q") {
        		print("Sorry you can't use this name. Retry please !");
        	}
        }while (player_name == "Q");
        ArrayList<String> al = new ArrayList<>();
        al.add(player_name);
        return al;
    }

    private char print_welcome_msg() {
        print("Hi Trainer ! Welcome to the arena !");
        print("Are you already registered? Y/N");
        char choice;
        while( ( (choice = TestsUI.test_char() ) != 'Y' ) && ( choice !='N' ) ) {
            print("Please enter a valid value !");
        }
        return choice;
    }
    
    private String ask_password(char login) {
    	Player player = game.get_player();
	    String password = "";
    	if (login == 'Y') {
	    	print("Please fill your password :");
	    	password = TestsUI.test_string( 20 );
	    	print("Sorry, this doesn't work right now, but enjoy the rest of the game while you wait...");
	    	
//TODO : Faire fonctionner cette saloperie de de chargement de deck
//TODO : Enregistrer les utilisateurs et verifier leur existence au login
//TODO : Crypter fichiers
	    	
//			print("Please wait while loading your data");
//	    	game.get_player().get_deck().set_deck( upload_deck( player ) );
	    	print("Welcome back " + player.toString() + ". I hope you're fine today !");
	    } else {
	    	print("Please fill a password for data backup :");
	    	password = TestsUI.test_string( 20 );
	    	print("OK " + player.toString() + ". I can feel you'll do great things !");
	    }
	    return password;
    }
  
    protected static void print(String str){
        System.out.println(str);
    }

    private void menu() {
        int choice;
        
        print("Do you want to :");
        print("1- Add a card to your deck");
        print("2- See your deck");
        print("3- Leave the game");
        choice = TestsUI.test_int(-1, 1, 3);
        
        switch(choice){
            case 1:
                ask_type_card();
                break;
            case 2:
                print_deck();
                break;
            case 3:
                goOn = false;
        }
    }

    private void ask_type_card() {
        HashMap<Integer,String> type_card_tab=new HashMap<>();
        type_card_tab.put(1, "ENERGY");
        type_card_tab.put(2, "POKEMON");
        type_card_tab.put(3, "TRAINER");
        int choice;
        
        print("What kind of card do you want to create :");
        print("1- ENERGY        2- POKEMON        3-TRAINER");
        
        choice = TestsUI.test_int(-1, 1, type_card_tab.size());

        game.get_player().add_card( (String)type_card_tab.get(choice) );
        
    }
    
    public static void report_creation_card(String c){
        print("Well done ! You've just created a new card " + c);
    }

    private void print_goodbye_msg() {
    	print("...Save of your deck in progress ...");
    	save_deck( game.get_player() );
        print("Bye " + game.get_player() + "! See you soon :D");
    }

    @SuppressWarnings("unchecked")
	private void print_deck() {
        ArrayList<Card> deck = game.get_player().get_deck().get_cards();
        char choice = ' ';
        
        
        print("------------------------------YOUR DECK !-------------------------------");
        if(deck.size() == 0){
            print("Your deck is empty !!");
            
        }else{  
            print("Give the cards number to print the entire cards or Q to quit the deck menu");
            for(int i = 0, n = deck.size() ; i < n ; i++){
                print( (i+1) + " - " + deck.get(i) );
            }
            choice=TestsUI.test_char();

            if(choice != 'Q'){
            	int index = (choice - '0') - 1;
                print("You want to see the card "+deck.get(index));
                Card c = deck.get(index);
                HashMap<String, String> get_map_card = c.get_map_card();
        		PrintCardUI.print_card(get_map_card);
            	menu_card(index, deck);
            	return;
            }
        }
    }
    
    private void menu_card(int index, ArrayList<Card> deck) {
        
        print("Do you want to :");
        print("1- Remove the card");
        print("2- Modify the card");
        print("3- Return to the deck");
        
        int choice = TestsUI.test_int(-1, 1, 3);
        
        if (choice == 2) {
        	game.get_player().add_card( deck.get(index).get_type_card() );
        }
        if (choice < 3) {
        	deck.remove(index);
        }
        
        print_deck();
        return;
    }
}
