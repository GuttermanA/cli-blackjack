package app.card;

public class Royal extends Card {
    public final String type;
    public final int value = 10;

    public Royal(String suit, String type) {
        super(suit);
        this.type = type;
    }

    @Override
    public String toString() {
        return String.valueOf(Character.toChars(this.unicodeSuit)) + this.type;
    }
}
