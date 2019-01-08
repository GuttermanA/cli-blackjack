package app.dealer;

import app.card.Ace;
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

    public Card revealDownCard() {
        Card card = this.hand.getCard(1);
        card.setHidden(false);
        return card;
    }

    public boolean checkHiddenBlackjack() {
        boolean result =  false;
        if(upCard instanceof Ace) {
            //ask for insurance
            result = hand.checkBlackJack();
        }

        return result;
    }

    public void play() {
        downCard.setHidden(false);
        System.out.println( System.lineSeparator() + "The dealers hand is: ");
        printHand();

        while(this.hand.getValue() <=16) {
            this.hand.addCard(dealFaceUp());
            printHand();
        }

        if(this.hand.getValue() > 21) {
            printBust();
        } else {
            printStand();
        }

        System.out.println("DEALER FINISHED");
    }

    @Override
    public String toString() {
        return this.hand.toString();
    }

    public void printHand() {
        System.out.println(this.toString());
    }

    public void printStand() {
//        printHand();
        System.out.println("The dealer stood." + System.lineSeparator());
    }

    public void printBust() {
//        printHand();
        System.out.println("The dealer busted!" + System.lineSeparator());
    }

    public void printOpeningHand() {
        System.out.println("The dealer's opening hand is an up " + this.upCard.toString());
    }

}
