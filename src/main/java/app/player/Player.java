package app.player;

import app.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {


    public final String name;
    public List<Card>  cards = new ArrayList<>();
    public int cardsValue = 0;
    public double bet = 0;
    public double winnings = 0;

    public Player() {
        this.name = "DEFAULT";
        this.winnings += 100;
    }

    public Player(String name, double winnings) {
        this.name = name;
        this.winnings += winnings;
    }

    public Player(double winnings) {
        this.name = "DEFAULT";
        this.winnings += winnings;
    }

    public void addCard(Card card) {
        cardsValue += card.value;
        cards.add(card);
    }

    public boolean checkBlackJack() {
        return cardsValue == 21;
    }

    public String cardsToString() {
        StringBuilder sb = new StringBuilder();
        for(Card card : cards) {
            sb.append("---");
            sb.append(System.lineSeparator());
            sb.append("|" + card.toString() + "|");
            sb.append(System.lineSeparator());
            sb.append("---  ");
        }
        return sb.toString();
    }
}
