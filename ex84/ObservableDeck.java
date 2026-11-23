import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 8.4 - ALL the observer-supporting code lives in this SUBCLASS of Deck.
 * It overrides draw() to add the notification after delegating to Deck.draw().
 */
public class ObservableDeck extends Deck {

    private final List<DeckObserver> aObservers = new ArrayList<>();

    public void addObserver(DeckObserver pObserver) {
        if (!aObservers.contains(pObserver)) {
            aObservers.add(pObserver);
        }
    }

    public void removeObserver(DeckObserver pObserver) {
        aObservers.remove(pObserver);
    }

    @Override
    public Card draw() {
        Card drawn = super.draw();           // original behaviour, unchanged
        for (DeckObserver observer : new ArrayList<>(aObservers)) {
            observer.cardDrawn(drawn, size()); // push: card + new size
        }
        return drawn;
    }
}
