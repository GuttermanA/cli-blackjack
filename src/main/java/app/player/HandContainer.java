package app.player;

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

    public void setCurrentHand(int currentHand) {
        if(currentHand <= hands.size()) {
            this.currentHand = currentHand;
        }
    }


}


