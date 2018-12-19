package app.card;

public class Ace extends Card {
    public int[] value = {1,11};
    public String type = "A";

    public Ace(String suit) {
        super(suit);
    }



    @Override
    public String toString() {
        return String.valueOf(Character.toChars(this.unicodeSuit)) + this.type;
    }

}
