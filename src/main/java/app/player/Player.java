package app.player;

import app.card.Card;

public class Player {


    public final String name;
    public final HandContainer  hands;
//    public int cardsValue = 0;
    public double bet = 0;
    public double winnings = 0;

    public Player() {
        this.name = "DEFAULT";
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

    public double getBet() {
        return this.bet;
    }
}
