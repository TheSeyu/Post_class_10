/**
 * Concrete observer: prints the size of the deck whenever it changes.
 */
public class SizeStatus implements DeckObserver {

    @Override
    public void cardDrawn(Card pCard, int pSize) {
        // The size of a Deck only changes when a card is drawn.
        System.out.println("SizeStatus : the deck now has " + pSize + " cards");
    }
}
