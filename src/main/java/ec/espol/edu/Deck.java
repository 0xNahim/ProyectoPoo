package ec.espol.edu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Deck {
    private ArrayList<Carta> mazo;
    static Random ran = new Random();


    public Deck() {
        mazo = new ArrayList<>();
        
    }
    public void DeckJuego(){
        mazo = new ArrayList<>();
        inicializarBaraja();
        barajar();
    }

    public void inicializarBaraja() {
        // Cartas normales del 0 al 9 (excepto N)
        for (Color color : Color.values()) {
            if (color != Color.N) {
                for (int i = 0; i <= 9; i++) {
                    mazo.add(new CartaNormal(i, color));
                }
            }
        }

        // Cartas especiales
        for(int i=0; i<2; i++){
            for (Color color : Color.values()) {
                if (color != Color.N) {
                    mazo.add(new Chupa4(color));
                    mazo.add(new Bloqueo(color));
                    mazo.add(new Reversa(color));
                    mazo.add(new Chupa2(color));
                }
            }
        }


        // Cartas de cambio de color y +4 (no tienen color)
        for (int i = 0; i < 2; i++) {
            mazo.add(new Chupa2());
            mazo.add(new Chupa4());
            mazo.add(new CambioColor(Color.N));
        }
    }
    public void barajar() {
        Collections.shuffle(mazo, ran);
    }

    public Carta robarCarta() {
        if (mazo.isEmpty()) {
            return null;
        }
        return mazo.remove(0);
    }

    public ArrayList<Carta> getMazo() {
        return mazo;
    }

    public void repartirCartas(Jugador jugador, int j) {
        for (int i = 0; i < j; i++) {
            jugador.recibirCarta(robarCarta());
        }
    }

    //reparte 7 cartas al azar, de cualquier posicion de la baraja como lo pide el documento
    public void repartirCartasr(Jugador jugador, int j) {
        for (int i = 0; i < 7; i++) {
            jugador.recibirCarta(mazo.remove(ran.nextInt(mazo.size())));
        }
    }
    
}
