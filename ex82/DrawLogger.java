/**
 * Concrete observer (pull): prints a description of every card drawn.
 */
public class DrawLogger implements DeckObserver {

    @Override
    public void deckChanged(ReadOnlyDeck pDeck) {
        // Pulls the data it needs. pDeck.draw() or pDeck.shuffle() do not compile.
        System.out.println("DrawLogger : drew " + pDeck.getLastDrawn());
    }
}
