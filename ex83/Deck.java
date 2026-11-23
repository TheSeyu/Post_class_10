import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * Exercise 8.3 - Deck inherits addObserver/removeObserver/notifyObservers
 * from the superclass DeckObservable. It only keeps its own card logic and
 * the single call that fires the notification.
 */
public class Deck extends DeckObservable {

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
        Card drawn = aCards.pop();
        notifyObservers(drawn, aCards.size()); // inherited from DeckObservable
        return drawn;
    }

    public int size() {
        return aCards.size();
    }

    public boolean isEmpty() {
        return aCards.isEmpty();
    }
}
