package app.game;

import app.card.Ace;
import app.dealer.Dealer;
import app.dealer.Deck;
import app.player.Hand;
import app.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {


    public final List<Player> players;
    public int activePlayer = 0;
    public Dealer dealer;
    public Scanner sc = new Scanner(System.in);
//    public final double minBet = 1;

    public Game(List<Player> players, int numDecks) {
        this.players = players;
        this.dealer = new Dealer(players, numDecks);
    }

    public Game(List<Player> players) {
        this.players = players;
        this.dealer = new Dealer(players);
    }

    public Game() {
        this.players = new ArrayList<Player>();
        players.add(new Player());
        this.dealer = new Dealer(this.players);
    }

    public Game(int numDecks) {
        this.players = new ArrayList<Player>();
        players.add(new Player());
        this.dealer = new Dealer(this.players, numDecks);
    }



    public void start() {
        dealer.dealOpeningCards();
        printTurn();

        for(int i = 0; i < players.size(); i++) {
            new Turn(i, players.get(i), dealer, sc);
        }

//        dealer.checkHiddenBlackjack();
    }

    public void end() {
        System.out.println("Thanks for playing!");
        System.exit(0);
    }


    public void printActivePlayerHand() {
        System.out.println(players.get(activePlayer).toString());
    }

    public void printTurn() {
        dealer.printOpeningHand();
        System.out.println("------------------------------------");
        printActivePlayerHand();
    }

}
