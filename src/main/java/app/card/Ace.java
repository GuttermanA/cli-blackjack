package app.card;

public class Ace extends Royal {
    public int[] value = {1,11};
    public String type = "A";

    public Ace(String suit) {
        super(suit);
    }

    public int getHighValue() {
        return this.value[1];
    }

    public int getLowValue() {
        return this.value[0];
    }

}
