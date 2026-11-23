/**
 * Client code for Exercise 8.4: the client must create an ObservableDeck
 * (not a plain Deck) to be able to register observers.
 */
public class Demo {

    public static void main(String[] args) {
        ObservableDeck deck = new ObservableDeck();
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

        System.out.println("--- a plain Deck still works, with no observer overhead ---");
        Deck plain = new Deck();
        System.out.println("plain deck drew " + plain.draw());
    }
}
