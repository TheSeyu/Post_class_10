import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 8.3 - ALL the observer-supporting code lives in this SUPERCLASS.
 * Deck extends it and only has to call notifyObservers(...) when it changes.
 */
public abstract class DeckObservable {

    private final List<DeckObserver> aObservers = new ArrayList<>();

    public void addObserver(DeckObserver pObserver) {
        if (!aObservers.contains(pObserver)) {
            aObservers.add(pObserver);
        }
    }

    public void removeObserver(DeckObserver pObserver) {
        aObservers.remove(pObserver);
    }

    /** Push strategy: tells every observer which card was drawn and the new size. */
    protected void notifyObservers(Card pDrawn, int pSize) {
        for (DeckObserver observer : new ArrayList<>(aObservers)) {
            observer.cardDrawn(pDrawn, pSize);
        }
    }
}
