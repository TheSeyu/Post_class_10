/**
 * Concrete observer (pull): prints the size of the deck whenever it changes.
 */
public class SizeStatus implements DeckObserver {

    @Override
    public void deckChanged(ReadOnlyDeck pDeck) {
        System.out.println("SizeStatus : the deck now has " + pDeck.size() + " cards");
    }
}
