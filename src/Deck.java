import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();

    public void fillDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14; j++) {
                String rank;
                if (j == 1) {
                    rank = "A";
                } else if (j == 11) {
                    rank = "J";
                } else if (j == 12) {
                    rank = "Q";
                } else if (j == 13) {
                    rank = "K";
                } else {
                    rank = Integer.toString(j);
                }
                String fn = rank +
                        (Suit.values()[i]).toString().substring(0, 1)
                                .toUpperCase()
                        + ".png";
                Card card = new Card(Suit.values()[i], j, fn);
                cards.add(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public ArrayList<Card> drawHand() {
        ArrayList<Card> hand = new ArrayList<Card>();
        for (int i = 0; i < 5; i++) {
            hand.add(cards.get(i));
        }
        return hand;
    }
}