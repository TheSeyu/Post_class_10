/**
 * Exercise 8.2 - Interface Segregation Principle.
 *
 * This is the "narrow" view of a Deck that observers are allowed to see.
 * It only contains QUERY methods; the methods that change the state of the
 * deck (draw, shuffle) are deliberately NOT part of it. An observer that only
 * depends on ReadOnlyDeck therefore cannot modify the Deck it is watching.
 */
public interface ReadOnlyDeck {

    /** @return the number of cards currently in the deck */
    int size();

    /** @return true if the deck has no more cards */
    boolean isEmpty();

    /**
     * @return the card that was most recently drawn,
     *         or null if no card has been drawn yet
     */
    Card getLastDrawn();
}
