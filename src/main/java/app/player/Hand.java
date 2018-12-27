package app.player;

import app.card.Ace;
import app.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private int value = 0;
    private int lowAceValue;
    public final List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public Hand(List<Card> cards) {
        this.cards = cards;
        this.setValue();
    }

    public void addCard(Card card) {
        this.value += card.value;
        this.cards.add(card);
    }

    private void setValue() {
        this.value = 0;
        for(Card card : this.cards) {
            if(card instanceof Ace) {
               this.lowAceValue += ((Ace) card).getLowValue();
            } else {
                this.value += card.value;
            }

        }
    }

    public int getValue() {
        return this.value;
    }

    public boolean blackJack() {
        return this.value == 21;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Card card : this.cards) {
            sb.append(card.toString());
            sb.append(" ");
        }

        sb.append("The current value of the hand is" + this.value);

        return sb.toString().trim();
    }

}
