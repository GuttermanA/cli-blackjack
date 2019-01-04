package app.game;

import app.dealer.Dealer;
import app.error.HandException;
import app.player.Player;

import java.util.Arrays;
import java.util.Scanner;

public class Turn {

    //If up card is ace, ask for insurance and check if black jack
    //First player turn
    //Check if black jack
    //If not, continue and get cards

    public static final String[] actions = { "h", "st", "sp", "d"};
    public static final String actionMessaage = "Please stand, hit, or double:";
    public static final String splitActionMessage = "Please stand, hit, split, or double:";
    public static final String hitOrStandMessage = "Please stand or hit";

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
        int currentHandIndex = 0;
        while(activePlayer.getHands().size() > currentHandIndex) {
            try {
                firstPlayerAction();
            } catch (TurnException ex) {
                ex.printStackTrace();
            }
            currentHandIndex++;
            activePlayer.setCurrentHand(currentHandIndex);
        }


        dealer.play();
    }


//    public void insurance(Scanner sc) {
//        while (!playerInput.nextLine().toLowerCase().equals("y") || !playerInput.toLowerCase().equals("n")) {
//            System.out.println("Please enter 'y' or 'n'");
//        }
//    }

    public void firstPlayerAction() throws TurnException {
        System.out.println(System.lineSeparator() + actionMessaage);
        while(checkInput()) {
            System.out.println(actionMessaage);
        }

        if(this.playerInput.toString().equalsIgnoreCase("h")) {
            hit();
        } else if(this.playerInput.toString().equalsIgnoreCase("st")) {
            stand();
        } else if(this.playerInput.toString().equalsIgnoreCase("d")) {
            doubleDown();
        } else if(this.playerInput.toString().equalsIgnoreCase("sp")) {
            try {
                split();
            } catch (HandException ex) {
                throw new TurnException(ex);
            } catch (TurnException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void hitOrStandAction() {

    }

    public void hit () {
        activePlayer.addCard(dealer.dealFaceUp());

        if(activePlayer.hands.getCurrentHand().getValue() > 21) {
            return;
        }
    }

    public void stand() {
        return;
    }

    public void split() throws HandException, TurnException {
        if(!activePlayer.hands.getCurrentHand().canSplit()) throw new TurnException("Invalid input because hand cannot be split");
        activePlayer.split();
    }

    public void doubleDown() {
        activePlayer.doubleDown(dealer.dealFaceUp());
        return;
    }

    public boolean checkInput() {
        boolean result = true;
        if(Arrays.asList(actions).contains(playerInput.nextLine().toLowerCase()))
            result = false;


        return result;
    }


}


class TurnException extends Exception {
    public TurnException(String message) {
        super(message);
    }

    public TurnException(String message, Throwable cause) {
        super(message, cause);
    }

    public TurnException(Throwable cause) {
        super(cause);
    }
}