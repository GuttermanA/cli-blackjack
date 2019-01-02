package app.player;

import app.card.Ace;
import app.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private int value = 0;
//    private int lowAceValue;
    public final List<Card> cards;
    private int numAces = 0;



    public Hand() {
        this.cards = new ArrayList<>();
    }

    public Hand(List<Card> cards) {
        this.cards = cards;
        this.setValue();
    }

    public Card addCard(Card card) {
        this.cards.add(card);
        this.setValue();
        return card;
    }

    public Card getCard(int index) {
        return this.cards.get(index);
    }

    private void setValue() {
        this.value = 0;
        for(Card card : this.cards) {
//            if(card.isHidden()) {
//                continue;
//            }
            if(card instanceof Ace) {
                this.addAce();
                Ace ace = (Ace) card;
                if(this.value + ace.getHighValue() > 21) {
                    this.value += ace.getLowValue();
                } else {
                    this.value += ace.getHighValue();
                }
            } else {
                this.value += card.value;
            }

        }
    }

    public int getValue() {
        return this.value;
    }

    public int getNumAces() {
        return this.numAces;
    }

    public void addAce() {
        this.numAces++;
    }

    public int getLowAceValue() {
        return this.value - (10 + numAces);
    }

    public boolean blackJack() {
        return this.value == 21;
    }

    public boolean isCardHidden() {
        for(Card card : cards) {
            if(card.isHidden()) return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Card card : this.cards) {
            sb.append(card.toString());
            sb.append(" ");
        }
        sb.append(System.lineSeparator());

        if (isCardHidden()) {
            sb.append(this.hiddenCardMessage());
        } else if(this.getNumAces() > 0) {
            sb.append(this.withAceMessage());
        } else {
            sb.append(this.withoutAceMessage());
        }

        return sb.toString().trim();
    }

    public String withAceMessage() {
        return "The value of the hand is " + this.getLowAceValue() + " or " + this.getValue() + ".";
    }

    public String withoutAceMessage() {
        return "The value of the hand is " + this.getValue() + ".";
    }

    public String hiddenCardMessage() {
        return "The current value of the hand is hidden.";
    }


}
