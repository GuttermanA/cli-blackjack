package app.game;

import app.dealer.Dealer;
import app.error.HandException;
import app.player.Hand;
import app.player.Player;

import java.util.Scanner;

public class Turn {

    //If up card is ace, ask for insurance and check if black jack
    //First player turn
    //Check if black jack
    //If not, continue and get cards

//    public static final String[] actions = { "h", "st", "sp", "d"};
//    public static final String actionMessaage = "Please stand, hit, or double:";
//    public static final String splitActionMessage = "Please stand, hit, split, or double:";
//    public static final String hitOrStandMessage = "Please stand or hit";

    public static final ActionSingleton ACTION_SET = ActionSingleton.getInstance();;

    public int turnNum;



    public Player activePlayer;
    public Dealer dealer;
    public Scanner playerInput;

    public Turn(int turnNum, Player activePlayer, Dealer dealer, Scanner playerInput) throws HandException {
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

    public void start() throws HandException {
        int currentHandIndex = -1;
//        while(activePlayer.getHands().size() > currentHandIndex) {
//            currentHandIndex++;
//            if(this.activePlayer.checkBlackJack()) {
//                activePlayer.printBlackJack();
//                return;
//            }
//            try {
//                playerAct();
//            } catch (TurnException ex) {
//                ex.printStackTrace();
//            }
//
//            activePlayer.setCurrentHand(currentHandIndex);
//        }

        try {
                playerAct();
            } catch (TurnException ex) {
                ex.printStackTrace();
            }

        dealer.play();
    }


//    public void insurance(Scanner sc) {
//        while (!playerInput.nextLine().toLowerCase().equals("y") || !playerInput.toLowerCase().equals("n")) {
//            System.out.println("Please enter 'y' or 'n'");
//        }
//    }

    public void playerAct() throws TurnException, HandException {

        //Validation is not required on below logic because check input handles if its valid for the given hand

        System.out.println("INTIALI ACTION");
        printActionMessage();

        String nextLine = this.playerInput.next();
//        System.out.println("Accepted input");

        this.checkInput(nextLine);

//        if(nextLine.equalsIgnoreCase("h")) {
//            hit();
//            if (activePlayer.getCurrentHand().getValue() < 21) playerAct();

//        }
//        else if(nextLine.equalsIgnoreCase("st")) {
//            stand();
//        } else if(nextLine.equalsIgnoreCase("d")) {
//            doubleDown();
//        } else if(nextLine.equalsIgnoreCase("sp")) {
//            try {
//                split();
//            } catch (HandException ex) {
//                throw new TurnException(ex);
//            } catch (TurnException ex) {
//                ex.printStackTrace();
//            }
//
//        }



        while (nextLine.equalsIgnoreCase("h") && activePlayer.getCurrentHand().getValue() < 21) {
            hit();

            if (activePlayer.getCurrentHand().getValue() > 20)
                break;
//            } else {
//                playerAct();
//            }
            System.out.println("ACTING INSIDE HIT");
            printActionMessage();
            nextLine = this.playerInput.next();

        }


    }

    public void processAction(String action) throws TurnException, HandException {
        if(action.equalsIgnoreCase("h")) {
            hit();
            if (activePlayer.getCurrentHand().getValue() < 21) playerAct();

        } else if(action.equalsIgnoreCase("st")) {
            stand();
        } else if(action.equalsIgnoreCase("d")) {
            doubleDown();
        } else if(action.equalsIgnoreCase("sp")) {
            try {
                split();
            } catch (HandException ex) {
                throw new TurnException(ex);
            } catch (TurnException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void hit () {
        activePlayer.addCard(dealer.dealFaceUp());
        if(activePlayer.hands.getCurrentHand().getValue() > 21) {
            activePlayer.printBust();
        } else {
            activePlayer.printHand();
        }
    }

    public void stand() {
        activePlayer.printStand();
    }

    public void split() throws HandException, TurnException {
        if(!activePlayer.hands.getCurrentHand().canSplit()) throw new TurnException("Invalid input because hand cannot be split");
        activePlayer.split();
    }

    public void doubleDown() {
        activePlayer.doubleDown(dealer.dealFaceUp());
        activePlayer.printHand();
    }

    //
    public void checkInput(String playerInput) throws HandException {
        while(ACTION_SET.checkInput(playerInput, activePlayer.getCurrentHand())) {
            printActionMessage();
        }
    }

    public void printActionMessage() throws HandException {
        System.out.println(System.lineSeparator() + generateActionMessage());
    }

    public String generateActionMessage() throws HandException {
        Hand currentHand = activePlayer.getCurrentHand();
        int actionInt = ACTION_SET.getActionSet(currentHand);
        return ACTION_SET.getMessage(actionInt);
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