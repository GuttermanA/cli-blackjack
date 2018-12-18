package app.deck;

import app.card.Card;

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
            for(Integer value : Card.values) {
                for(String suit : Card.suits) {
                    deckArray.add(new Card(value, suit));
                }
            }

            for(String royal : Card.royals) {
                int value = royal.equals("ACE") ? 1 : 10;
                for(String suit : Card.suits) {
                    deckArray.add(new Card(value, suit, royal));
                }
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
//        int counter = 1;

        while(iterator.hasNext()) {

//            System.out.println(counter);
            System.out.println(iterator.next().toString());
//            counter++;
        }

//
//        for(Object card : this) {
//            System.out.println(counter);
//            counter++;
//        }
    }

}
