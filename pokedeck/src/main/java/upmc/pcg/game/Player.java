/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;

/**
 *
 * @author Laura
 */
public class Player {
    private String name;
    private String password;
    private boolean isPlaying;
    private Deck deck=new Deck();
    
    public Player(){
        this.name="Player 1";
        this.isPlaying=true;
    }
    public Player(String name){
        this.name=name;
        this.isPlaying=true;
    }
    
    public void add_card(String card_type){
        this.deck.create_card(card_type);
    }
    
    public Deck get_deck(){
        return this.deck;
    }

    public String toString(){
        return this.name;
    }
    
    public void set_password(String pwd) {
    	this.password = pwd;
    }
    
    public void play(boolean inOut){
        this.isPlaying=inOut;
    }
    
    public boolean get_isPlaying(){
        return this.isPlaying;
    }
    
    protected String get_password() {
    	return this.password;
    }
}
