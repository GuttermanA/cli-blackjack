package app.card;

public class Card {
    public static final int[] values = {2,3,4,5,6,7,8,9,10};
    public static final String[] suits = {"SPADES","HEARTS", "DIAMONDS", "CLUBS"};
    public static final String[] royals = {"J", "Q","K"};

    public final int value;
    public final int unicodeSuit;
    public final String suit;

//    public Card() {
//        this.value = 0;
//        this.unicodeSuit = 0;
//        this.suit = null;
//    }

    public Card(int value, String suit) {
        this.value = value;
        this.unicodeSuit = unicodeSuitLookup(suit);
        this.suit = suit;
    }

    public Card(String suit) {
        this.value = 0;
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

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return String.valueOf(Character.toChars(this.unicodeSuit)) + this.value;
//        return "Card{" +
//                "value=" + value +
//                ", unicodeSuit=" + unicodeSuit +
//                ", suit='" + suit + '\'' +
//                ", royal='" + royal + '\'' +
//                '}';
    }
}
