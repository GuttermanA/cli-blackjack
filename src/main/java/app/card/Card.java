package app.card;

public class Card {
    public static final int[] values = {2,3,4,5,6,7,8,9,10};
    public static final String[] suits = {"SPADES","HEARTS", "DIAMONDS", "CLUBS"};
    public static final int unicodeCardBack = 0x1F0A0;

    public static final String[] royals = {"J", "Q","K"};

    public final int value;



    protected final int unicodeSuit;
    protected final String suit;

    protected boolean hidden = false;


    public Card(int value, String suit) {
        this.value = value;
        this.unicodeSuit = unicodeSuitLookup(suit);
        this.suit = suit;
    }

    public Card(String suit) {
        this.value = 10;
        this.unicodeSuit = unicodeSuitLookup(suit);
        this.suit = suit;
    }


    private int unicodeSuitLookup(String suit) {
        if(suit.equals("SPADES")) return 0x2660;

        if(suit.equals("HEARTS")) return 0x2665;

        if(suit.equals("DIAMONDS")) return 0x2666;

        if(suit.equals("CLUBS")) return 0x2663;

        return 0x0000FFFD;
    }

    public boolean isAce() {
        return this instanceof Ace;
    }

    public int getValue() {
        return value;
    }

    public int getUnicodeSuit() {
        return this.hidden ? unicodeCardBack : this.unicodeSuit;
    }

    public String getSuit() {
        return suit;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }


    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return this.hidden ? "" : String.valueOf(Character.toChars(this.getUnicodeSuit())) + (this.getValue());
    }
}
