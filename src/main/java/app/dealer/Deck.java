package app.dealer;

import app.card.Ace;
import app.card.Card;
import app.card.Royal;

import java.util.*;

public class Deck {

    public final Deque<Card> cards = new ArrayDeque<>();

    public Deck(int numDecks) {
        cards.addAll(generateCards(numDecks));
    }

    public Deck() {
        cards.addAll(generateCards(1));
    }

    private List<Card> generateCards(int numDecks) {
        List<Card> deckArray = new ArrayList<>();

        for (int i = 0; i < numDecks; i++) {

            //Add number cards
            for (Integer value : Card.values) {
                for (String suit : Card.suits) {
                    deckArray.add(new Card(value, suit));
                }
            }

            //Add royal cards
            for (String type : Card.royals) {
                for (String suit : Card.suits) {
                    deckArray.add(new Royal(suit, type));
                }
            }

            //Add aces
            for (String suit : Card.suits) {
                deckArray.add(new Ace(suit));
            }
        }


        Collections.shuffle(deckArray);

        return deckArray;
    }

    public Card removeFirst() {
        return cards.removeFirst();
    }



    public void print() {
        Iterator iterator = cards.iterator();
        int counter = 1;

        while(iterator.hasNext()) {

            System.out.println(counter);
            System.out.println(iterator.next().toString());
            counter++;
        }

    }

}
