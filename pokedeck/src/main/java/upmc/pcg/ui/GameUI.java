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
import upmc.pcg.game.Game;

public class GameUI {
  private final Game game = new Game();
  private final static Scanner console = new Scanner(System.in);
  private boolean goOn=true;
  

  public void start() {
    print_welcome_msg();
    ArrayList<String> names = ask_players_names();
    game.initialize(names);
    
    while(goOn){
        menu();
    }
    game.play();
    print_goodbye_msg();
  }

    private ArrayList<String> ask_players_names() {
        String player_name="";
        print("What's your name ?");

        player_name=test_string( );

        print("OK "+player_name+". I can feel you'll do great things !");
        ArrayList al=new ArrayList<>();
        al.add(player_name);
        return al;
    }

    private void print_welcome_msg() {
        print("Hi Trainer ! Welcome to the arena !");
    }

    private String test_string() {

          String str="";
          String test="";

          while(str.equals("") || str.length()>20){
              test=this.console.nextLine();
              if(!test.equals("")){ 
                  while(test.charAt(0)==' ' && test.length()>1){
                      test=test.substring(1);
                  }
              }
              if(!test.equals(" ")){
                 str=test;     
              }else{
                  str="";
                  print("Please enter a REAL name");
              }
          }
          return str;
    }
    private static int test_int(int not_a_choice, int min, int max) {
        int i=not_a_choice;
        
        while(i==not_a_choice){
            if(console.hasNextInt()){
                i = console.nextInt();
                if(i>max || i<min){
                    i=not_a_choice;
                    print("Please enter a valid value !");
                }
            }else{
                i=not_a_choice; 
                print("Please enter a valid value !");
            }
            console.nextLine();
        }
        return i;
    }
    public static char test_char(){
        char res=' ';
        while(res==' '){
            String test=console.nextLine();
            if(test.equals("")){
                res=' ';
                print("Please enter a valid value !");
            }else{
                test=test.toUpperCase();
                res=test.charAt(0); 
            }  
        }
        
        return res;    
    }
    
  
    private static void print(String str){
        System.out.println(str);
    }

    private void menu() {
        int choice;
        
        print("Do you want to :");
        print("1- Add a card to your deck");
        print("2- See your deck");
        print("3- Leave the game");
        choice=test_int(-1,1,3);
        
        switch(choice){
            case 1:
                ask_type_card();
                break;
            case 2:
                print_deck();
                break;
            case 3:
                goOn=false;
        }
    }

    private void ask_type_card() {
        HashMap type_card_tab=new HashMap();
        type_card_tab.put(1, "ENERGY");
        type_card_tab.put(2, "POKEMON");
        type_card_tab.put(3, "TRAINER");
        int choice;
        
        print("What kind of card do you want to create :");
        print("1- ENERGY        2- POKEMON        3-TRAINER");
        
        choice = test_int(-1, 1, type_card_tab.size());

        game.get_player().add_card((String)type_card_tab.get(choice));
        
    }
    public static String ask_energy_type(String energies[]){

        String str="";
        int choice;
       
        for(int i=0;i<energies.length; i++){
            str+=(i+1)+" - "+energies[i]+"      ";
        }
         print("An ENERGY card ! But wich kind ?");
         print(str);
         
         choice = test_int(-1,1,energies.length)-1;
         
         return energies[choice];
        
    }
    public static void report_creation_card(String c){
        print("Well done ! You've just created a new card "+c);
    }

    private void print_goodbye_msg() {
        print("Bye "+game.get_player()+"! See you soon :D");
    }

    private void print_deck() {
        ArrayList deck=game.get_player().get_deck().get_cards();
        char choice=' ';
        
        
        print("------------------------------YOUR DECK !-------------------------------");
        print("Give the cards number to print the entire cards or Q to quit the deck menu");
        for(int i=0; i<deck.size(); i++){
            print( (i+1)+" - "+ deck.get(i) );
        }
        choice=test_char();

        if(choice!='Q'){
            int index=(int)choice - 1;
            print("You want to see the card "+deck.get(0));
        }
    }
  
}
