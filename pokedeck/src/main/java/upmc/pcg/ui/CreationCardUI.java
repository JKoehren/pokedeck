package upmc.pcg.ui;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Laura
 */

public class CreationCardUI implements TestsUI {
	
    public static String ask_energy_type( HashMap<Integer,String> energy_type, String type ) {
    	
        int choice;
        print( "Wich kind of energy has your " + type + "?" );
        print( print_hashMap( energy_type ) );
        choice = TestsUI.test_int( -1, 1, energy_type.size() );
        return ( String ) energy_type.get( choice );
    }
    
    public static String ask_name( String type ) {
    	
        String name = "";
        print( "What's your " + type + "'s name? (max 15 char)" );
        name = TestsUI.test_string(15);
        return name;
    }
    
    public static String ask_attack_name() {
    	
        print( "Add a basic attack to your pokemon. First, what is the name of your attack? (max 20 char)" );
        String name = TestsUI.test_string( 20 );
        return name;
    }
    
    public static int ask_attack_strenght() {
    	
        print( "How strong is your attack? (from 10 to 70 HP)" );
        int strenght = TestsUI.test_int( -1, 9, 71 );
        return strenght;
    }
    
    public static ArrayList<String> ask_attack_energy(HashMap<Integer,String> energy_type) {
    	
        ArrayList<String> energy_needed = new ArrayList<>();
        print( "How many ENERGY cards will you need to have? (From 1 to 5)" );
        int number = TestsUI.test_int( -1, 0, 6 );
        
        for( int i = 1 ; i <= number ; i++ ) {
        	
            print( "Card " + i + ": wich energy?" );
            print( print_hashMap( energy_type ) );
            energy_needed.add( ( String ) energy_type.get( TestsUI.test_int( -1,1,energy_type.size() ) ) );
        }

        return energy_needed;
    }
    
    public static int ask_hp() {
    	
        print( "How many HP does it have? (max 200)" );
        int hp = TestsUI.test_int( -1, 0, 200 );
        return hp;
    }
    
    public static String ask_weakness( HashMap<Integer,String> energy_type ) {
        
    	int choice;
        print( "What is your pokemon's weakness?" );
        print( print_hashMap( energy_type ) );
        choice = TestsUI.test_int( -1, 1, energy_type.size() );
        return ( String ) energy_type.get( choice );
    }
    
    public static String ask_resistance( HashMap<Integer,String> energy_type ) {
    	
        int choice;
        print( "To wich energy does he resist well?" );
        print( print_hashMap( energy_type ) );
        choice = TestsUI.test_int( -1, 1, energy_type.size() );
         
        return ( String ) energy_type.get( choice );
    }
    
	public static HashMap ask_retreat( HashMap<Integer, String> energy_type ) {
		
        String energy;
        int number;
        HashMap retreat = new HashMap();
        print( "Wich energy will you have to spend to retreat?" );
        print( print_hashMap( energy_type ) );
        energy = ( String ) energy_type.get( TestsUI.test_int( -1, 1, energy_type.size() ) );
        retreat.put( "energy", energy );
        print( "How much " + energy + " ENERGY card will retreat cost? (10 max)" );
        number = TestsUI.test_int( -1, 0, 10 );
        retreat.put( "number", number );
        return retreat;
    }

    private static String print_hashMap( HashMap<Integer,String> to_print ) {
    	
        String str = "";
        
        for( int i = 1, n = to_print.size() ; i <= n ; i++ ) {
        	
            if( to_print.containsKey(i) ) {
                str += i + " - " + to_print.get(i) + "      "; 
            }
        }
        
        return str;
    }
    
    protected static void print( String str ) {
        System.out.println( str );
    }

    public static boolean ask_if_add_attack() {
    	
        char add; // Wordplay !
        boolean rhapsodie = true; //Other pun 
        print( "Do you want to add a major attack? Y/N" );
        char[] ok = { 'Y', 'N' };
        add = TestsUI.test_char( ok );
       
        if( add == 'N' ) {
            rhapsodie = false;
        }
        
        return rhapsodie;
    }

    public static String ask_description( String type ) {
    	
        String description = "";
        print( "Add a description to your " + type + " (Max : 200 char)" );
        description = TestsUI.test_string(200);
        return description;
    }
}