package app.card;

public class Card {
    public static final int[] values = {2,3,4,5,6,7,8,9,10};
    public static final String[] suits = {"SPADES","HEARTS", "DIAMONDS", "CLUBS"};
    public static final String[] royals = {"ACE", "JACK", "QUEEN","KING"};

    public final int value;
    public final int unicodeSuit;
    public final String suit;
    public final String royal;

    public Card() {
        this.value = 0;
        this.unicodeSuit = 0;
        this.suit = null;
        this.royal = null;
    }

    public Card(int value, String suit) {
        this.value = value;
        this.unicodeSuit = unicodeSuitLookup(suit);
        this.suit = suit;
        this.royal = null;
    }

    public Card(int value, String suit, String royal) {
        this.value = value;
        this.unicodeSuit = unicodeSuitLookup(suit);
        this.suit = suit;
        this.royal = royal;
    }


    private int unicodeSuitLookup(String suit) {
        if(suit.equals("SPADES")) return 0x2660;

        if(suit.equals("HEARTS")) return 0x2665;

        if(suit.equals("DIAMONDS")) return 0x2666;

        if(suit.equals("CLUBS")) return 0x2663;

        return 0x0000FFFD;
    }

    @Override
    public String toString() {
        String value = this.royal != null ? royal : Integer.toString(this.value);
        return String.valueOf(Character.toChars(this.unicodeSuit)) + value;
//        return "Card{" +
//                "value=" + value +
//                ", unicodeSuit=" + unicodeSuit +
//                ", suit='" + suit + '\'' +
//                ", royal='" + royal + '\'' +
//                '}';
    }
}
