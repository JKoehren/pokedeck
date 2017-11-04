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
import java.util.Enumeration;
import upmc.pcg.Card;
import upmc.pcg.game.Game;
import upmc.pcg.game.Player;
import upmc.pcg.game.Serializer;

public class GameUI extends Serializer implements TestsUI {
	
    private final Game game = new Game();

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
        char[] ok = {'Y', 'N'};
        char choice = TestsUI.test_char(ok);
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
    	ArrayList<Card> deck = game.get_player().get_deck().get_cards();
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
                print_deck(deck);
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
	private void print_deck(ArrayList<Card> deck) {
        
        print("------------------------------YOUR DECK !-------------------------------");
        if(deck.size() == 0){
            print("Your deck is empty !!");
            
        }else{ 
        	print("Give the cards number to print the entire cards or :");
            print("Q to quit the deck menu");
            print("S to select by name");
            print("T to sort by type");
            print("");
            for(int i = 0, n = deck.size() ; i < n ; i++){
                print( (i+1) + " - " + deck.get(i) );
            }
            print_card(deck);
        }
    }
    
    private void print_card(ArrayList<Card> deck) {
    	ArrayList<Card> search = new ArrayList<Card>();
    	String choice = "";
        int index=-1;
        do{
            choice=TestsUI.test_string(2);
            if (choice.charAt(0) == 'S') {
            	index=-3;
            }else if(choice.charAt(0) == 'T') {
            	index=-4;
            }else if (choice.charAt(0) != 'Q'){
                try{
                   index = Integer.parseInt(choice); 
                   if(index > deck.size() || index < 1){
                        index=-1;
                        print("Please enter a good value");
                   }
                }catch(NumberFormatException e){ 
                    index=-1;
                    print("Please enter a good value");
                }
            }else{
                index=-2;
            }    
        }while( index == -1 );
        
        if(index == -3) {
        	
        	print("Which one do you want to see? (Write his name, max 15 char)");
        	choice=TestsUI.test_string(15);
        	for(int i = 0, n = deck.size() ; i < n ; i++){
                String cardList = deck.get(i) +"";
                String[] cardName = cardList.split(":");
                if (cardName[1].toLowerCase().indexOf(choice.toLowerCase()) > -1) {
                	index = -2;
                	search.add(deck.get(i));
                }
            }
        	if (index == -3) {
        		print("No card found with this name!");
        		index++;
        	}else{
        		print_deck(search);
        	}
        }
        
        if (index == -4) {
        	print("What kind of cards should we display?");
        	print("1 : Energy");
        	print("2 : Pokemon");
        	print("3 : Trainer");
        	int choiceType=TestsUI.test_int(-1, 1, 3);
        	choiceType--;
        	String[] types = {"energy","pokemon","trainer"};
        	for(int i = 0, n = deck.size() ; i < n ; i++){
        		String cardList = deck.get(i) +"";
                String[] cardName = cardList.split(":");
                if (cardName[0].toLowerCase().indexOf(types[choiceType]) > -1) {
                	search.add(deck.get(i));
                	index = -2;
                }
        	}
        	if (index == -4) {
        		print("No card found with this type!");
        		index++;
        		index++;
        	}else{
        		print_deck(search);
        	}
        }
        
        if(index!=-2){
            index--;
            print("You want to see the card "+deck.get(index));
            Card c = deck.get(index);
            HashMap<String, String> get_map_card = c.get_map_card();
            PrintCardUI.print_card(get_map_card);
            menu_card(index, deck);
        }
    }
    
    private void menu_card(int index, ArrayList<Card> deck) {
        
        print("");
        print("Do you want to :");
        print("1- Remove the card");
        print("2- Modify the card");
        print("3- Return to the deck");
        
        int choice = TestsUI.test_int(-1, 1, 3);
        
        switch(choice){
            case 1:
                print("Are you sure you want to removed "+ deck.get(index) +"? (Y/N)");
                char[] ok = {'Y', 'N'};
                char erase=TestsUI.test_char(ok);
                if( erase == 'Y'){
                    print(deck.get(index)+"...is removed");
                    deck.remove(index);
                }else{
                    print("Removing removal ...");
                }
                break;
            case 2:
                menu_card_modification(deck.get(index));
                break;
            default:
            	print_deck(deck);
                break;
        }

    }

    private void menu_card_modification(Card c) {
        HashMap c_map = c.get_map_card();
        HashMap<Integer, String> c_arguments = new HashMap();
        Set<String> c_keys = c_map.keySet();
        Iterator<String> it = c_keys.iterator();
        int i=1;
        
        print("What do you wanna change?");
 
        while(it.hasNext()){
            String next=it.next();
            if( !c_map.get( next ).equals("") && !next.equals("card_type") && (!next.contains("attack") || next.equals("attack1_name"))){
                if( next.equals("energy_type")) next = "energy";
                if( next.equals("attack1_name")) next = "attacks";
                if( next.equals("retreat_cost")) next = "retreat";
                
                print( i +" "+ next );
                c_arguments.put( i, next );
                i++;
            }
        }
        
        int choice =TestsUI.test_int(-1, 1, i);

        c.set_argument(c_arguments.get(choice));

    }
}
