package app.deck;

import app.card.Ace;
import app.card.Card;
import app.card.Royal;

import java.util.*;

public class Deck extends ArrayDeque {

    public Deck(int numDecks) {
        this.addAll(generateCards(numDecks));
    }

    public Deck(){
        this.addAll(generateCards(1));
    }

    private List<Card> generateCards(int numDecks) {
        List<Card> deckArray = new ArrayList<>();

        for(int i = 0; i < numDecks; i++) {

            //Add number cards
            for(Integer value : Card.values) {
                for(String suit : Card.suits) {
                    deckArray.add(new Card(value, suit));
                }
            }

            //Add royal cards
            for(String type : Card.royals) {
                for(String suit : Card.suits) {
                    deckArray.add(new Royal(suit, type));
                }
            }

            //Add aces
            for(String suit : Card.suits) {
                deckArray.add(new Ace(suit));
            }
        }



        Collections.shuffle(deckArray);

        return deckArray;
    }

    public Card deal() {
        return (Card) this.removeFirst();
    }



    public void print() {
        Iterator iterator = this.iterator();
        int counter = 1;

        while(iterator.hasNext()) {

            System.out.println(counter);
            System.out.println(iterator.next().toString());
            counter++;
        }

    }

}
