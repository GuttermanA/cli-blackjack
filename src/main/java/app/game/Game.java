package app.game;

import app.card.Card;
import app.deck.Deck;
import app.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {


    public final Player[] players;
    public final Deck deck;
    public List<Card> dealerCards = new ArrayList<>();
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
        for(int i= 0; i < 3; i++) {
            for(int j = 0; i < (players.length * 2) + 2; j++) {
                if(i == 0) {
                    dealerCards.add(deck.deal());
                } else {
                    players[i - 1].cards.add(deck.deal());
                }
            }
        }

    }

}
