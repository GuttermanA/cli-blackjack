package app.game;

import app.dealer.Dealer;
import app.error.HandException;
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
//        players.add(new Player());
        this.dealer = new Dealer(this.players);
    }

    public Game(int numDecks) {
        this.players = new ArrayList<Player>();
        players.add(new Player());
        this.dealer = new Dealer(this.players, numDecks);
    }

    public void addPlayer(String name) {
        if(name.equalsIgnoreCase("")) {
            this.players.add(new Player());
        } else {
            this.players.add(new Player(name));
        }

        System.out.println("Player " + this.players.size() + " '" + name + "' " + "has been added.");

    }



    public void start() throws HandException {

        System.out.println(welcomeMessage());
//        System.out.println("------------------------------------");



        this.addPlayer(sc.nextLine());

        System.out.println(continueMessage());
        System.out.println("------------------------------------");

        String nextLine = sc.nextLine();

        while (!nextLine.equalsIgnoreCase("q")) {

            dealer.dealOpeningCards();
            printTurn();

            for(int i = 0; i < players.size(); i++) {
                Player currentPlayer = players.get(i);
                new Turn(i, currentPlayer, dealer, sc);
                currentPlayer.reset();
            }



            System.out.println(continueMessage());
            System.out.println("------------------------------------");
            nextLine = sc.nextLine();
        }



        end();
    }

    public void end() {
        System.out.println("Thanks for playing!");
        System.exit(0);
    }


    public void printActivePlayerHand() {
        System.out.println(players.get(activePlayer).toString() + System.lineSeparator());
    }

    public void printTurn() {
        dealer.printOpeningHand();
        System.out.println("------------------------------------");
        printActivePlayerHand();
    }

    public String welcomeMessage() {
        return "Welcome to CLI BlackJack" + System.lineSeparator() + "You can exit at anytime by entering 'q'" + System.lineSeparator() + "Please enter your name:";
    }

    public String continueMessage() {
        return "Press 'q' to quit, and any other key to continue:";
    }

}
