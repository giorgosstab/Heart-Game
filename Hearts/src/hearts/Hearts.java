/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hearts;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Been Touched
 */
public class Hearts {

    /**
     * @param args the command line arguments
     */
    public static class Game{
        ArrayList<HeartsPlayer> player = new ArrayList<>();
        
        public Game(int rounds){
            HeartsDealer dealer = new HeartsDealer();
            player.add(createPlayer());
            player.add(createPlayer());
            HeartsPlayer winner = this.playRounds(dealer, player, rounds);
            dealer.announceWinner(winner);
        }
        
        private HeartsPlayer playRounds(HeartsDealer dealer, ArrayList<HeartsPlayer> player, int rounds){
            for(int i=1; i <= rounds ; i++ ){
                System.out.println("-----------------\nGame no. " + (i) + ".\n ");
                dealer.initDealer();
                dealer.dealToPlayers(player.get(0), player.get(1));
                dealer.cardsPickUp(player);
            }
            HeartsPlayer winner = dealer.decideWinner(player.get(0), player.get(1));
            return winner;
        }
        
        private HeartsPlayer createPlayer(){
            Scanner scan= new Scanner(System.in);
            
            System.out.println("Player's name: ");
            String name = scan.nextLine();
            
            System.out.println("Player's surname: ");
            String surname = scan.nextLine();
            
            System.out.println("Player's nickname: ");
            String nick = scan.nextLine();
            
            System.out.println("Player's age: ");
            int age = scan.nextInt();
            
            return new HeartsPlayer(name, surname, age, nick);
        }
    }
    
    
    public static void main(String[] args) {
        Game game = new Game(5);
    }
    
}
