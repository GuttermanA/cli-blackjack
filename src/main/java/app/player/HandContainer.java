package app.player;

import app.card.Card;

import java.util.ArrayList;
import java.util.List;

public class HandContainer {

    private int currentHand = 0;
    public List<Hand> hands = new ArrayList<>();

    public HandContainer() {
        this.hands.add(new Hand());
    }

    public Hand getCurrentHand() {
        return this.hands.get(currentHand);
    }

//    public HandContainer(Card card) {
//        this.hands.add(new Hand(card));
//    }

    public void addHand() {
        this.hands.add(new Hand());
    }

    public List<Hand> getHands() {
        return this.hands;
    }

    public void addHand(Card card) {
        this.hands.add(new Hand(card));
    }

    public void setCurrentHand(int currentHand) {
        if(currentHand <= hands.size()) {
            this.currentHand = currentHand;
        }
    }


}


