package app.dealer;

import app.card.Card;
import app.player.Hand;
import app.player.Player;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DealerTest {

    private static Dealer dealer;
    private static List<Player> players;
    private static Player player;

    @BeforeClass
    public static void oneTimeSetUp() throws Exception {

    }

    @AfterClass
    public static void oneTimeTearDown() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        players = new ArrayList<>();
        players.add(new Player());

        dealer = new Dealer(players);
        player = players.get(0);
//        dealer.dealOpeningCards();
    }

    @After
    public void tearDown() throws Exception {
//        player.reset();
//        player.printWinnings();
//        dealer.reset();
//        dealer.resetDeck();
    }

    @Test
    public void reset() {
        dealer.setBlackJack(true);
        dealer.setBusted(true);


        dealer.dealOpeningCards();

        dealer.reset();
        assertFalse(dealer.isBusted());
        assertFalse(dealer.isBlackJack());
        assertEquals(0, dealer.getCards().size());
    }

    @Test
    public void dealOpeningCards() {
        //Gives dealer 1 up card and 1 down card. Gives all players 2 up cards. All cards taken from deck.




        dealer.dealOpeningCards();

        assertEquals(52 - 2 - (2 * players.size()), dealer.getDeck().getNumCards());

        Hand dealerHand = dealer.getHand();
        Card upCard  = dealer.getUpCard();
        Card downCard = dealer.getDownCard();



        assertEquals(2, dealerHand.getCards().size());
        assertFalse(upCard.isHidden());
        assertTrue(downCard.isHidden());

        for(Player player : players) {
            Hand hand = player.getCurrentHand();
            Card firstCard = hand.getCard(0);
            Card secondCard = hand.getCard(1);
            assertFalse(firstCard.isHidden());
            assertFalse(secondCard.isHidden());
            assertEquals(2, hand.getCards().size());
        }


    }

    @Test
    public void resetDeck() {
    }

    @Test
    public void dealFaceUp() {
        //deals card from deck face up
        Deck deck = dealer.getDeck();
        int initialSize = deck.getNumCards();
        Card topCard = deck.cards.getFirst();

        Card dealtCard = dealer.dealFaceUp();

        assertEquals(topCard, dealtCard);
        assertFalse(topCard.isHidden());
        assertEquals(initialSize - 1, deck.getNumCards());
    }

    @Test
    public void dealFaceDown() {
        //deals card from deck facedown

        Deck deck = dealer.getDeck();
        int initialSize = deck.getNumCards();
        Card topCard = deck.cards.getFirst();

        Card dealtCard = dealer.dealFaceDown();

        assertEquals(topCard, dealtCard);
        assertTrue(topCard.isHidden());
        assertEquals(initialSize - 1, deck.getNumCards());
    }

    @Test
    public void revealDownCard() {
    }

    @Test
    public void checkHiddenBlackjack() {
        //returns true if blackjack
    }

    @Test
    public void play() {
    }

    @Test
    public void checkBlackJack() {
    }
}