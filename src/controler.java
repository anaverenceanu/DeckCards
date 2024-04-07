import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class controler {
    @FXML
    private ImageView card1;

    @FXML
    private ImageView card2;

    @FXML
    private ImageView card3;

    @FXML
    private ImageView card4;

    @FXML
    private ImageView card5;

    @FXML
    private GridPane cardPane;

    ArrayList<Card> hand;

    @FXML
    private Button pairsLabel;

    @FXML
    private void drawButtonClick(ActionEvent event) {
        Deck deck = new Deck();
        deck.fillDeck();
        deck.shuffle();
        hand = deck.drawHand();
        for (int x = 0; x < 5; x++) {
            try {
                InputStream stream = new FileInputStream("./src/PNG/" + hand.get(x).getFilename());
                Image image = new Image(stream);
                ImageView cardImage = (ImageView) cardPane.getChildren().get(x);
                cardImage.setImage(image);
            } catch (IOException er) {
                System.out.println(er);
            }
        }
    }

    @FXML
    void checkPairs(ActionEvent event2) {
        int pairCount = 0;
        int x = 0;
        ArrayList<Card> tempHand = new ArrayList<Card>();

        for (Card c : hand) {
            tempHand.add(c);
        }
        while (!tempHand.isEmpty()) {
            int y = 1;
            while (y < tempHand.size()) {
                if (tempHand.get(x).getRank() == tempHand.get(y).getRank()) {
                    pairCount++;
                    tempHand.remove(y);
                    break;
                }
                y++;
            }
            tempHand.remove(x);
        }
        pairsLabel.setText("You have " + Integer.toString(pairCount) + " pair(s)");
    }

}
