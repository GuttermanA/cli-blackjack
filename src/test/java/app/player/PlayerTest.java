package app.player;

import app.card.Card;
import app.card.Royal;
import app.dealer.Dealer;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {

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
        dealer.dealOpeningCards();
    }

    @After
    public void tearDown() throws Exception {
//        player.reset();
//        player.printWinnings();
//        dealer.reset();
//        dealer.resetDeck();
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

//    @Test
//    public void getHands() {
//    }
//
//    @Test
//    public void setCurrentHand() {
//    }
//
//    @Test
//    public void getCurrentHand() {
//    }
//
//    @Test
//    public void getCurrentHandValue() {
//    }
//
//    @Test
//    public void getBet() {
//    }

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
        //resets busted, blackJack, bet, and hands attributes
        player.busted = true;
        player.blackJack = true;
        player.bet = 100;

        player.reset();
        assertFalse(player.busted);
        assertFalse(player.blackJack);
        assertEquals(0, player.bet, .000001);
        assertEquals(0, player.getCurrentHand().cards.size());

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
//        //sets attribute busted based on current hand value and returns value
        assertFalse(player.checkBust());
        assertFalse(player.busted);

        Hand newHand = player.addHand(new Royal("SPADES", 'Q'), new Royal("SPADES", 'Q'));
        newHand.addCard(new Royal("SPADES", 'Q'));
        player.setCurrentHand(1);
        assertTrue(player.checkBust());
        assertTrue(player.busted);
    }

    @Test
    public void placeBet() {
        //sets bet attribute to given bet value and subtracts from winnings

        double bet = 1;
        double initialWinnings = player.winnings;
        player.placeBet(1);

        assertEquals(1, player.getBet(), .00001);
        assertEquals(player.winnings, initialWinnings - bet, .00001);

    }

    @Test
    public void push() {
        player.printWinnings();
        //increases winnings by bet
        double initialWinnings = player.winnings;
        player.placeBet(1);
        player.push();
        double newWinnings = player.winnings;

        assertEquals(initialWinnings, newWinnings, .0001);
    }

    @Test
    public void win() {
        //increases winnings by bet * 2
        double initialWinnings = player.winnings;
        player.placeBet(1);
        player.win();
        double newWinnings = player.winnings;

        assertEquals(initialWinnings + player.getBet(), newWinnings, .0001);
    }

    @Test
    public void blackJackWin() {
        //incraseas winnings by bet * 2.5
        double initialWinnings = player.winnings;
        player.placeBet(1);
        player.blackJackWin();
        double newWinnings = player.winnings;

        assertEquals(initialWinnings + player.getBet() * 1.5, newWinnings, .0001);
    }

    @Test
    public void lose() {
        //decrease winnings by bet
        double initialWinnings = player.winnings;
        player.placeBet(1);

        player.lose();
        double newWinnings = player.winnings;

        assertEquals(initialWinnings - player.getBet(), newWinnings , .0001);
    }

    @Test
    public void doubleDown() {
    }

}