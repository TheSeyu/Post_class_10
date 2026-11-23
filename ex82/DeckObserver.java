/**
 * Observer interface for a Deck (PULL data-flow strategy).
 *
 * The notification carries no data about the change. The observer receives a
 * reference to the subject, typed as the read-only interface, and "pulls"
 * whatever it needs.
 */
public interface DeckObserver {

    /**
     * Called by the Deck after its state has changed (a card was drawn).
     *
     * @param pDeck read-only view of the deck that changed
     */
    void deckChanged(ReadOnlyDeck pDeck);
}
