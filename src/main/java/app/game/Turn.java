package app.game;

import app.dealer.Dealer;
import app.player.Hand;
import app.player.Player;

import java.util.Arrays;
import java.util.Scanner;

public class Turn {

    //If up card is ace, ask for insurance and check if black jack
    //First player turn
    //Check if black jack
    //If not, continue and get cards

    public static final String[] actions = { "h", "st", "sp", "d"};

    public int turnNum;



    public Player activePlayer;
    public Dealer dealer;
    public Scanner playerInput;

    public Turn(int turnNum, Player activePlayer, Dealer dealer, Scanner playerInput) {
        this.turnNum = turnNum;
        this.activePlayer = activePlayer;
        this.dealer = dealer;
        this.playerInput = playerInput;
        this.start();
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    public void start() {
        activePlayerAct();
        dealer.play();
    }


//    public void insurance(Scanner sc) {
//        while (!playerInput.nextLine().toLowerCase().equals("y") || !playerInput.toLowerCase().equals("n")) {
//            System.out.println("Please enter 'y' or 'n'");
//        }
//    }

    public void activePlayerAct() {
        System.out.println(System.lineSeparator() + "Please stand, hold, split or double:");
        while(checkInput()) {
            System.out.println("Please stand, hold, split, or double");
        }
    }

    public boolean checkInput() {
        boolean result =  true;
        if(Arrays.asList(actions).contains(playerInput.nextLine().toLowerCase()))
            result = false;


        return result;
    }








}
