package app.dealer;

import app.card.Card;
import app.player.Hand;
import app.player.Player;

import java.util.List;

public class Dealer {
    public final Hand hand;
    public final Deck deck;
    public final List<Player> players;
    public Card upCard;
    public Card downCard;

    public Dealer(List<Player> players, int numDecks) {
        this.hand = new Hand();
        this.deck = new Deck(numDecks);
        this.players = players;
    }

    public Dealer(List<Player> players) {
        this.hand = new Hand();
        this.deck = new Deck();
        this.players = players;
    }

    public void dealOpeningCards() {
        for(int i= 0; i < 2; i++) {
            if(i == 0 ) {
                this.upCard = this.hand.addCard(dealFaceUp());
            } else {
                this.downCard = this.hand.addCard(dealFaceDown());
            }

            for(Player player : players) {
                player.hands.getCurrentHand().addCard(dealFaceUp());
            }
        }

    }


    public Card dealFaceUp() {
        return (Card) deck.removeFirst();
    }

    public Card dealFaceDown() {
        Card card = (Card) deck.removeFirst();
        card.setHidden(true);
        return card;
    }

    public void play() {
        downCard.setHidden(false);
        while(this.hand.getValue() <=16) {
            this.hand.addCard(dealFaceUp());
        }
    }

    @Override
    public String toString() {
        return this.hand.toString();
    }

    public void printHand() {
        System.out.println(this.toString());
    }

    public void printStand() {

    }

    public void printBust() {

    }

    public void printOpeningHand() {
        System.out.println("The dealer's opening hand is an up " + this.upCard.toString());
    }

}
