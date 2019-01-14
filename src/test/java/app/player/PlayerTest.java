package app.player;

import app.card.Card;
import app.dealer.Dealer;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PlayerTest {

    private static Dealer dealer;
    private static List<Player> players;
    private static Player player;

    @BeforeClass
    public static void oneTimeSetUp() throws Exception {
        players = new ArrayList<>();
        players.add(new Player());
        dealer = new Dealer(players);
        player = players.get(0);
    }

    @AfterClass
    public static void oneTimeTearDown() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        dealer.dealOpeningCards();
    }

    @After
    public void tearDown() throws Exception {
        player.reset();
        dealer.reset();
    }

    @Test
    public void hit() {
        //adds card from deck to current hand
        List<Card> hand = player.getCurrentHand().cards;
        int initialHandSize = hand.size();
        Card dealtCard = dealer.dealFaceUp();
        player.hit(dealtCard);
        int newHandSize = hand.size();
        Card lastCard = hand.get(hand.size() - 1);

        boolean cardEquivalent = dealtCard.equals(lastCard);
        boolean addedToHand = newHandSize == (initialHandSize + 1);
        assertTrue(cardEquivalent);
        assertTrue(addedToHand);
    }

    @Test
    public void getHands() {
    }

    @Test
    public void setCurrentHand() {
    }

    @Test
    public void getCurrentHand() {
    }

    @Test
    public void getCurrentHandValue() {
    }

    @Test
    public void getBet() {
    }

    @Test
    public void addCard() {
        //adds card from dealer to current hand at end
        Card dealtCard = dealer.dealFaceUp();
        List<Card> currentCards = player.getCurrentHand().cards;
        player.addCard(dealtCard);

        boolean newHandSizeEquals3 = player.getCurrentHand().cards.size() == 3;

        boolean lastCardIsDealtCard = currentCards.get(currentCards.size() - 1).equals(dealtCard);

        assertTrue(newHandSizeEquals3);
        assertTrue(lastCardIsDealtCard);
    }

    @Test
    public void split() {
        //creates another hand. Adds another card to both hands
        player.reset();
        player.addCard(new Card(6, "SPADES"));
        player.addCard(new Card(6, "SPADES"));
        List<Card> initialCards = new ArrayList<>(player.hands.getCurrentHand().cards);
//        Card firstCard = initialCards.get(0);
        Card secondCard = initialCards.get(1);
//        int initialNumHands = player.hands.getNumHands();

        player.split(dealer.dealFaceUp(), dealer.dealFaceDown());

        List<Card> newCards = new ArrayList<>(player.hands.getHands().get(1).cards);

        boolean firstCardNewHandEqualsSecondCardInitialHand = secondCard.equals(newCards.get(0));

        boolean twoHands = player.hands.getNumHands() == 2;

        boolean firstHandSizeTwo = player.hands.getHands().get(0).cards.size() == 2;

        boolean secondHandSizeTwo = player.hands.getHands().get(1).cards.size() == 2;

        assertTrue(firstCardNewHandEqualsSecondCardInitialHand);
        assertTrue(twoHands);
        assertTrue(firstHandSizeTwo);
        assertTrue(secondHandSizeTwo);

    }

    @Test
    public void reset() {
    }

    @Test
    public void checkZeroWinnings() {
        player.winnings = 0;
        boolean trueIfWinningsEqualsZero = player.checkZeroWinnings();
        assertTrue(trueIfWinningsEqualsZero);
    }

    @Test
    public void checkBlackJack() {
    }

    @Test
    public void checkBust() {
    }

    @Test
    public void placeBet() {
    }

    @Test
    public void push() {
    }

    @Test
    public void win() {
    }

    @Test
    public void blackJackWin() {
    }

    @Test
    public void lose() {
    }

    @Test
    public void printZeroWinningsLoss() {
    }

    @Test
    public void doubleDown() {
    }

}