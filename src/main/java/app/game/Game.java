package app.game;

import app.deck.Deck;
import app.player.Hand;
import app.player.Player;

public class Game {


    public final Player[] players;
    public int activePlayer = 0;
    public final Deck deck;
    public Hand dealer = new Hand();
    public final double minBet = 1;

    public Game(Player[] players, int numDecks) {
        this.players = players;
        this.deck = new Deck(numDecks);
//        this.dealer = new Dealer();
    }

    public Game(Player[] players) {
        this.players = players;
        this.deck = new Deck();
//        this.dealer = new Dealer();
    }

    public Game() {
        this.players = new Player[] {new Player()};
        this.deck = new Deck();
//        this.dealer = new Dealer();
    }

    public Game(int numDecks) {
        this.players = new Player[] {new Player()};
        this.deck = new Deck(numDecks);
//        this.dealer = new Dealer();
    }

    public void turn() {

        for(Player player : players) {

        }
    }

    public void dealOpeningCards() {
        for(int i= 0; i < 2; i++) {
            if(i == 0 ) {
                dealer.cards.add(deck.dealFaceUp());
            } else {
                dealer.cards.add(deck.dealFaceDown());
            }

            for(Player player : players) {
                player.hands.getCurrentHand().addCard(deck.dealFaceUp());
            }
        }

    }

    public void printDealerHand() {
        System.out.println(dealer.toString());
    }

    public void printActivePlayerHand() {
        System.out.println(players[activePlayer].hands.getCurrentHand().toString());
    }

    public void printTurn() {
        printDealerHand();
        System.out.println("------------------------------------");
        printActivePlayerHand();
    }

}
