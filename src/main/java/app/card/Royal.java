package app.card;

import java.util.Objects;

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
    public boolean canSplit(Object o) {
        if(o == this) return true;
        if(!(o instanceof Royal)) return false;
        Royal card = (Royal) o;

        return Objects.equals(this.type, card.type);
    }

    @Override
    public String toString() {
        return String.valueOf(Character.toChars(this.getUnicodeSuit())) + (this.isHidden() ? "" : this.getType());
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Royal)) return false;
        Royal card = (Royal) o;

        return this.unicodeSuit == card.unicodeSuit && Objects.equals(this.type, card.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unicodeSuit, suit, type);
    }
}
