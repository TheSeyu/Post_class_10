import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * Exercise 8.1 - Deck as the Subject (Observable) of the Observer pattern,
 * using the PUSH data-flow strategy.
 */
public class Deck {

    private final Deque<Card> aCards = new ArrayDeque<>();
    private final List<DeckObserver> aObservers = new ArrayList<>();

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                aCards.push(new Card(rank, suit));
            }
        }
    }

    /* ---------- Subject (observable) part ---------- */

    public void addObserver(DeckObserver pObserver) {
        if (!aObservers.contains(pObserver)) {
            aObservers.add(pObserver);
        }
    }

    public void removeObserver(DeckObserver pObserver) {
        aObservers.remove(pObserver);
    }

    // Iterate over a copy so an observer may unregister itself while being notified.
    private void notifyObservers(Card pDrawn) {
        for (DeckObserver observer : new ArrayList<>(aObservers)) {
            observer.cardDrawn(pDrawn, aCards.size()); // push: card + new size
        }
    }

    /* ---------- Original Deck behaviour ---------- */

    public void shuffle() {
        List<Card> cards = new ArrayList<>(aCards);
        Collections.shuffle(cards);
        aCards.clear();
        aCards.addAll(cards);
    }

    /**
     * Draws the top card and notifies all observers.
     *
     * @pre !isEmpty()
     */
    public Card draw() {
        assert !isEmpty();
        Card drawn = aCards.pop();
        notifyObservers(drawn);
        return drawn;
    }

    public int size() {
        return aCards.size();
    }

    public boolean isEmpty() {
        return aCards.isEmpty();
    }
}
