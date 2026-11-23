/**
 * Observer interface for a Deck (PUSH data-flow strategy).
 *
 * The Deck "pushes" all the data an observer could need as arguments of the
 * notification, so an observer never has to call back into the Deck.
 */
public interface DeckObserver {

    /**
     * Called by the Deck right after a card has been drawn.
     *
     * @param pCard the card that was just drawn
     * @param pSize the number of cards left in the deck after the draw
     */
    void cardDrawn(Card pCard, int pSize);
}
