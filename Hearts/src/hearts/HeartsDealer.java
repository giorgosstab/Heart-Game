/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hearts;

import java.util.ArrayList;


/**
 *
 * @author Been Touched
 */
public class HeartsDealer {
    private Deck deck = new Deck();
    
    public HeartsDealer(){
        
        System.out.println("Dealer initialized.");
    }
    
    public Card dealRandomCard(){
        return deck.getRandomCard();
    }
    
    public void shuffleDeck(){
        this.deck.shuffleDeck();
    }
    
    public Card dealCard(){
        return this.deck.dealCard();
    }
    
    public void dealToPlayers(HeartsPlayer player1, HeartsPlayer player2){
        for(int i = 0; i < 5 ; ){
            player1.dealCardTo(this.dealCard());
            player1.printDeck();
            player2.dealCardTo(this.dealCard());
            player2.printDeck();
            System.out.println("Round " + (++i) + " complete, "+player1.getName()+" hearts in deck: " + player1.getHeartsOnDeck() + " "+player2.getName()+" hearts on deck: " + player2.getHeartsOnDeck() + "." + "\n*********\n");
        }
        this.arrangePoints(player1, player2);
        System.out.println("Total points "+player1.getName()+": " + player1.getPoints() + "\nTotal points "+player2.getName()+": " + player2.getPoints());
    }
    
    private void arrangePoints(HeartsPlayer player1, HeartsPlayer player2){
        if(player1.getHeartsOnDeck() > player2.getHeartsOnDeck()){
            player1.addPoints((player1.getHeartsOnDeck() - player2.getHeartsOnDeck()) * 10);
        }else{
            player2.addPoints((player2.getHeartsOnDeck() - player1.getHeartsOnDeck()) * 10);
        }
    }

    public HeartsPlayer decideWinner(HeartsPlayer player1, HeartsPlayer player2) {
        if(player1.getPoints() > player2.getPoints()){
            return player1;
        }else if (player2.getPoints() > player1.getPoints()){
            return player2;
        }else{
            return null;
        }
    }
    
    public void announceWinner(HeartsPlayer player){
        if(player == null){
            System.out.println("Tie.");
        }else{
            System.out.println("Winning player is: " + player.introduceSelf());
        }
    }
    
    public void initDealer(){
        this.deck.initializeFullDeck();
        this.deck.shuffleDeck();
        System.out.println("Dealer has been initialized and deck is shuffled.");
    }

    public void cardsPickUp(ArrayList<HeartsPlayer> player) {
        for(HeartsPlayer pl: player){
            pl.emptyDeck();
        }
    }

    
}
