import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * Exercise 8.2 - observable Deck using the PULL data-flow strategy.
 * Observers only get to see the Deck through the ReadOnlyDeck interface.
 */
public class Deck implements ReadOnlyDeck {

    private final Deque<Card> aCards = new ArrayDeque<>();
    private final List<DeckObserver> aObservers = new ArrayList<>();
    private Card aLastDrawn; // state that observers pull through ReadOnlyDeck

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

    private void notifyObservers() {
        for (DeckObserver observer : new ArrayList<>(aObservers)) {
            observer.deckChanged(this); // pull: observer only sees ReadOnlyDeck
        }
    }

    /* ---------- Mutators: NOT visible through ReadOnlyDeck ---------- */

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
        aLastDrawn = aCards.pop();
        notifyObservers();
        return aLastDrawn;
    }

    /* ---------- Queries: exposed through ReadOnlyDeck ---------- */

    @Override
    public int size() {
        return aCards.size();
    }

    @Override
    public boolean isEmpty() {
        return aCards.isEmpty();
    }

    @Override
    public Card getLastDrawn() {
        return aLastDrawn;
    }
}
