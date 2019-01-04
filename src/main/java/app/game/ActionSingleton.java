package app.game;

import app.error.HandException;
import app.player.Hand;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ActionSingleton {

    private static ActionSingleton instance = null;

//    public static final String[] actions = { "h", "st", "sp", "d"};
//    public static final String actionMessaage = "Please stand, hit, or double:";
//    public static final String splitActionMessage = "Please stand, hit, split, or double:";
//    public static final String hitOrStandMessage = "Please stand or hit";

//    private Scanner playerAction;

    public String lastAction;

    public Map<Integer, HashMap<String, Object>> actionMap;

    private ActionSingleton() {
        this.actionMap = new HashMap<>();
        actionMap.put(0, new HashMap<>());
        Map hitOrStand = actionMap.get(0);
        hitOrStand.put("actions", new String[] {"h", "st"});
        hitOrStand.put("message", "Please hit or stand");
        actionMap.put(1, new HashMap<>());
        Map hitStandOrDouble = actionMap.get(1);
        hitStandOrDouble.put("actions", new String[] {"h", "st", "d"});
        hitStandOrDouble.put("message", "Please hit, stand, or double");
        actionMap.put(2, new HashMap<>());
        Map hitStandDoubleOrSplit = actionMap.get(2);
        hitStandDoubleOrSplit.put("actions", new String[] {"h", "st", "d", "sp"});
        hitStandDoubleOrSplit.put("message", "Please hit, stand, double, or split");
    }

    public static ActionSingleton getInstance() {
        if (instance == null) {
            instance = new ActionSingleton();
        }
        return instance;
    }

    public String[] getActions(int actionLevel) {
        return (String[]) actionMap.get(actionLevel).get("actions");
    }

    public String getMessage(int actionLevel) {
        return (String) actionMap.get(actionLevel).get("message");
    }

    public boolean checkInput(Scanner playerInput, Hand hand) throws HandException {
        boolean result = true;
        if(Arrays.asList(getActions(getActionSet(hand))).contains(playerInput.nextLine().toLowerCase()))
            result = false;


        return result;
    }

    public int getActionSet(Hand hand) throws HandException {
        int actionLevel = 0;

        if(hand.numCards() == 2) {
            actionLevel++;
            if(hand.canSplit()) actionLevel++;
        }

        return actionLevel;
    }
}
