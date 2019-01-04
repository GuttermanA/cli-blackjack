package app;

import app.error.HandException;
import app.game.Game;

public class App {
    public static void main(String[] args) throws HandException {
//        System.out.println(Character.toChars(	0x0000FFFD));
//        Deck dealer = new Deck();
//        dealer.print();
        Game game = new Game();

        game.start();

    }




}
