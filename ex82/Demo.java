/**
 * Client code demonstrating the Observer pattern on Deck.
 */
public class Demo {

    public static void main(String[] args) {
        Deck deck = new Deck();
        DeckObserver logger = new DrawLogger();
        DeckObserver status = new SizeStatus();

        deck.addObserver(logger);
        deck.addObserver(status);

        System.out.println("--- two observers registered, draw 2 cards ---");
        deck.draw();
        deck.draw();

        System.out.println("--- SizeStatus unregistered, draw 1 card ---");
        deck.removeObserver(status);
        deck.draw();
    }
}
