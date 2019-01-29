package app.hand;

import app.card.Ace;
import app.card.Card;
import app.exception.HandException;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private int value = 0;
    private int lowAceValue = 0;
    private final List<Card> cards;
    private int numAces = 0;



    public Hand() {
        this.cards = new ArrayList<>();
    }

    public Hand(List<Card> cards) {
        this.cards = cards;
        this.setValue();
    }

    public Hand(Card card) {
        this.cards = new ArrayList<>();
        this.cards.add(card);
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

    public Card removeCard(int index) {
        return this.cards.remove(index);
    }

    public boolean removeCard(Card card) {
        return this.cards.remove(card);
    }

    public List<Card> getCards() {
        return this.cards;
    }

    private void setValue() {
        this.value = 0;
        for(Card card : this.cards) {
            if(card instanceof Ace) {
                this.addAce();
                Ace ace = (Ace) card;
                this.lowAceValue = ace.getLowValue() + this.value;
                this.value += ace.getHighValue();
//                if(this.value + ace.getHighValue() > 21) {
//                    this.value += ace.getLowValue();
//                } else {
//                    this.value += ace.getHighValue();
//                }
            } else {
                this.value += card.value;
            }

        }
    }

    public int getValue() {
        return this.value > 21 ? this.getLowAceValue() : this.value;
    }

    public int getNumAces() {
        return this.numAces;
    }

    public void addAce() {
        this.numAces++;
    }

    private int getLowAceValue() {
        return this.lowAceValue;
//        return this.value - (10 * numAces);
    }

    public boolean checkBlackJack() {
        return this.value == 21 && this.cards.size() == 2;
    }

    public boolean checkBust() {

        return this.getValue() > 21;
    }

    public int numCards() {
        return cards.size();
    }

    public boolean isCardHidden() {
        for(Card card : cards) {
            if(card.isHidden()) return true;
        }

        return false;
    }

    public boolean canSplit() throws HandException {
        if(cards.size() > 2) throw new HandException("Split can only occur when 2 cards are in hand");

        return cards.get(0).equals(cards.get(1));
    }

    public String withSoftAceMessage() {
        return "The value of the hand is " + this.getLowAceValue() + " or " + this.getValue() + ".";
    }

    public String withHardAceMessage() {
        return "The value of the hand is" + this.getLowAceValue() + ".";
    }

    public String withoutAceMessage() {
        return "The value of the hand is " + this.getValue() + ".";
    }

    public String hiddenCardMessage() {
        return "The current value of the hand is hidden.";
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
            if(this.getValue() > 21) {
                sb.append(this.withHardAceMessage());
            } else {
                sb.append(this.withSoftAceMessage());
            }

        } else {
            sb.append(this.withoutAceMessage());
        }

        return sb.toString().trim();
    }




}

