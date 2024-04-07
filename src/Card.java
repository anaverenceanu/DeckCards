enum Suit {
    spades,
    hearts,
    diamonds,
    clubs
}

public class Card {
    private Suit suit;
    private int rank;
    private String filename;

    public Suit getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public String getFilename() {
        return filename;
    }

    public Card(Suit s, int r, String f) {
        suit = s;
        rank = r;
        filename = f;
    }

    public String toString() {
        return "Rank: " + rank + " Suit: " + suit + "Filename:" + filename;
    }
}