/**
 * Concrete observer: prints a description of every card drawn.
 */
public class DrawLogger implements DeckObserver {

    @Override
    public void cardDrawn(Card pCard, int pSize) {
        System.out.println("DrawLogger : drew " + pCard);
    }
}
