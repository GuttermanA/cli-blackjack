package app.player;

import app.card.Card;
import app.error.HandException;

import java.util.List;

public class Player {


    public final String name;
    public HandContainer  hands;
//    public int cardsValue = 0;
    public double bet = 0;
    public double winnings = 0;
    public boolean busted = false;
    public boolean blackJack = false;

    public Player() {
        this.name = "The Man with No Name";
        this.winnings += 100;
        this.hands = new HandContainer();
    }

    public Player(String name) {
        this.name = name;
        this.winnings = 100;
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

    public Hand getCurrentHand() {
        return this.hands.getCurrentHand();
    }

    public int getCurrentHandValue() {
        return this.getCurrentHand().getValue();
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

    public void reset() {
        this.busted = false;
        this.blackJack = false;
        this.hands = new HandContainer();
    }

    public boolean checkBlackJack () {
        this.blackJack = getCurrentHand().checkBlackJack();
        return this.blackJack;
    }

    public boolean checkBust() {
        this.busted = getCurrentHand().checkBust();
        return this.busted;
    }

    public void placeBet(double bet) {
        this.setBet(bet);
        printBet();
    }

    public void push() {
        printPush();
    }

    public void win() {
        this.winnings += this.bet;
        printWin();
    }

    public void lose() {
        printLose();
    }

    public void doubleDown(Card card) {
        this.bet *= 2;
        addCard(card);
    }

    public void printHand() {
        System.out.println(this.name + " has:" + System.lineSeparator() + this.toString() + System.lineSeparator());
    }

    public void printBet() {
        System.out.println(this.name + " bet " + this.bet);
    }

    public void printBust() {
        printHand();
        System.out.println(this.name + " busted!" + System.lineSeparator());
    }

    public void printStand() {
        System.out.println(this.name + " stood with a " + this.getCurrentHand().getValue() + System.lineSeparator());
    }

    public void printBlackJack() {
        System.out.println(this.name + " has a Black Jack!");
        printWin();
    }

    public void printWin() {
        System.out.println(this.name + " won " + this.bet);
    }

    public void printLose() {
        System.out.println(this.name + " lost " + this.bet);
    }

    public void printPush() {
        System.out.println(this.name + " pushed.");
    }

    @Override
    public String toString() {
        return hands.getCurrentHand().toString();
    }


}
