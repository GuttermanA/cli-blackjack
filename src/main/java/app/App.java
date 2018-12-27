package app;

import app.game.Game;

public class App {
    public static void main(String[] args) {
//        System.out.println(Character.toChars(	0x0000FFFD));
//        Deck deck = new Deck();
//        deck.print();
        Game game = new Game();

        game.dealOpeningCards();

        game.printTurn();

    }




}
