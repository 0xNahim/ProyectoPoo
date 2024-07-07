package ec.espol.edu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Deck deckjuego = new Deck();
        deckjuego.DeckJuego();
        System.out.println(deckjuego.getMazo().size());

    }
}