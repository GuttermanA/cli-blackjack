package app.card;

public class Royal extends Card {
    public final String type;
    public final int value = 10;

    public Royal(String suit, String type) {
        super(suit);
        this.type = type;
    }

    public Royal(String suit) {
        super(suit);
        this.type = null;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return String.valueOf(Character.toChars(this.getUnicodeSuit())) + (this.isHidden() ? "" : this.getType());
    }
}
