package app.player;

import app.card.Card;
import app.error.HandException;

import java.util.List;

public class Player {


    public final String name;
    public final HandContainer  hands;
//    public int cardsValue = 0;
    public double bet = 0;
    public double winnings = 0;

    public Player() {
        this.name = "The Man with No Name";
        this.winnings += 100;
        this.hands = new HandContainer();
    }

    public Player(String name, double winnings) {
        this.name = name;
        this.winnings += winnings;
        this.hands = new HandContainer();
    }

    public Player(String name, double winnings, HandContainer hands) {
        this.name = name;
        this.winnings += winnings;
        this.hands = hands;
    }

    public Player(double winnings) {
        this.name = "DEFAULT";
        this.winnings += winnings;
        this.hands = new HandContainer();
    }

    public void hit(Card card) {
        hands.getCurrentHand().addCard(card);
    }

    public void setBet(double bet) {
        this.bet = bet;
        this.winnings -= bet;
    }

    public List<Hand> getHands() {
        return this.hands.getHands();
    }

    public void setCurrentHand(int index) {
        this.hands.setCurrentHand(index);
    }

    public double getBet() {
        return this.bet;
    }

    public void addCard(Card card) {
        hands.getCurrentHand().addCard(card);
    }

    public void split() {
        try {
            hands.getCurrentHand().canSplit();
        } catch (HandException ex) {
            ex.printStackTrace();
        }
        Card firstCard = hands.getCurrentHand().cards.get(0);
        Card secondCard = hands.getCurrentHand().cards.get(1);
        if(firstCard.value == secondCard.value) {
            this.hands.addHand(secondCard);
            hands.getCurrentHand().cards.remove(secondCard);
        }
    }

    public void doubleDown(Card card) {
        this.bet *= 2;
        addCard(card);
    }

    @Override
    public String toString() {
        return hands.getCurrentHand().toString();
    }

    public void printHand() {
        System.out.println(this.name + "has:" + System.lineSeparator() + this.toString());
    }
}
