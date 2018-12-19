package app.player;

import app.card.Card;

import java.util.ArrayList;
import java.util.List;

public class HandContainer extends ArrayList {


    public int currentHand = 0;

    public HandContainer() {
        this.add(new ArrayList< Card >());
    }

    public List<Card> primary() {
        return (List<Card>) this.get(0);
    }




}

class Hand extends ArrayList {
    public int value = 0;

    public void addCard(Card card) {

        this.value += card.value;
        this.add(card);
    }

    public boolean checkAce(Card card) {
        return card.suit.equals("ACE");
    }

//    public int aceValue(Card card) {
//
//    }
}
