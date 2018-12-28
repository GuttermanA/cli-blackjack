package app.game;

import app.player.Hand;
import app.player.Player;

public class Turn {

    //If up card is ace, ask for insurance and check if black jack
    //First player turn
    //Check if black jack
    //If not, continue and get cards

    public int turnNum;
    public Player activePlayer;
    public Hand dealer;
    public String playerInput = null;

    public Turn(Player activePlayer, Hand dealer) {
        this.turnNum = 0;
        this.activePlayer = activePlayer;
        this.dealer = dealer;
    }







}
