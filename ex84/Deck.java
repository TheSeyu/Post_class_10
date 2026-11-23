import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * Exercise 8.4 - the ORIGINAL Deck: it knows nothing about observers.
 * All the observer code lives in the subclass ObservableDeck.
 */
public class Deck {

    private final Deque<Card> aCards = new ArrayDeque<>();

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                aCards.push(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        List<Card> cards = new ArrayList<>(aCards);
        Collections.shuffle(cards);
        aCards.clear();
        aCards.addAll(cards);
    }

    /**
     * @pre !isEmpty()
     */
    public Card draw() {
        assert !isEmpty();
        return aCards.pop();
    }

    public int size() {
        return aCards.size();
    }

    public boolean isEmpty() {
        return aCards.isEmpty();
    }
}
