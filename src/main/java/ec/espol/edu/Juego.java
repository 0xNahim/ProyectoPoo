package ec.espol.edu;

import java.util.Scanner;

public class Juego {
    private Persona jugador1;
    private Maquina maquina;
    private final Deck deckjuego;
    private Carta cartaActual;
    private int turnoactual = 1;

    public Juego(String nombrePersona, String nombreMaquina) {
        deckjuego = new Deck();
        deckjuego.DeckJuego();
        jugador1 = new Persona(nombrePersona);
        maquina = new Maquina(nombreMaquina);
        cartaActual = deckjuego.robarCarta();
        while (cartaActual.getColor().equals(Color.N)){
            cartaActual = deckjuego.robarCarta();
        }
        deckjuego.repartirCartasr(jugador1,7);
        deckjuego.repartirCartasr(maquina,7);
    }

    public void jugar() {
        Scanner s = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {

            if (turnoactual % 2 != 0) {
                System.out.println("Mazo del bot:");
                maquina.imprimirMano();
                System.out.println("Cantidad de cartas de la maquina: " + maquina.getNumeroCartas());
                if(jugador1.getNumeroCartas()==1){
                    System.out.println("UNO");
                }else if(maquina.getNumeroCartas()==1){
                    System.out.println("Maquina: Uno");
                }
                Carta cartaJugada = jugador1.jugarCarta(cartaActual);
                if (cartaJugada != null) {
                    if (cartaJugada instanceof CambioColor) {
                        ((CambioColor) cartaJugada).cambiarColor();
                    }
                    if (cartaJugada instanceof Chupa4) {
                        if((((Chupa4) cartaJugada).color).equals(Color.N)){
                            ((Chupa4) cartaJugada).cambiarColor();
                        }
                        deckjuego.repartirCartas(maquina,4);
                        /*turnoactual=+2; 
                        en el juego real la persona pierde su turno pero el documento no lo dice
                        */
                    }
                    if (cartaJugada instanceof Chupa2) {
                        if((((Chupa2) cartaJugada).color).equals(Color.N)){
                            ((Chupa2) cartaJugada).cambiarColor();
                        }
                        deckjuego.repartirCartas(maquina,2);
                        /*turnoactual=+2; 
                        en el juego real la persona pierde su turno pero el documento no lo dice
                        */
                    }
                    if (cartaJugada instanceof Bloqueo) {
                        turnoactual=+2;
                    }
                    if (cartaJugada instanceof Reversa) {
                        turnoactual=+2;
                    }
                    cartaActual = cartaJugada;
                    if (jugador1.mano.getMazo().isEmpty()) {
                        System.out.println("¡" + jugador1.nombre + " gana!");
                        continuar = false;
                    }
                    
                } else {
                    System.out.println("¡Carta no válida! Debes robar una carta.");
                    deckjuego.repartirCartas(jugador1,1);
                }
                turnoactual++;
            } else {
                System.out.println("\n Turno de " + maquina.nombre);
                Carta cartaJugada = maquina.jugarCarta(cartaActual);
                if (cartaJugada != null) {
                    if (cartaJugada instanceof CambioColor) {
                        ((CambioColor) cartaJugada).cambiarColorAutomatico();
                    }
                    if (cartaJugada instanceof Chupa4) {
                        ((Chupa4) cartaJugada).cambiarColorAutomatico();
                        //System.out.println("\n Pierdes el Turno");
                        deckjuego.repartirCartas(jugador1,4);
                        //turnoactual=-1;
                    }
                    if (cartaJugada instanceof Chupa2) {
                        if((((Chupa2) cartaJugada).color).equals(Color.N)){
                            ((Chupa2) cartaJugada).cambiarColorAutomatico();
                        }
                        deckjuego.repartirCartas(jugador1,2);
                        //turnoactual=-1;
                    }
                    if (cartaJugada instanceof Bloqueo) {
                        System.out.println("\n Pierdes el Turno!");
                        turnoactual=-1;
                    }
                    if (cartaJugada instanceof Reversa) {
                        System.out.println("\n Pierdes el Turno!");
                        turnoactual=-1;
                    }
                    cartaActual = cartaJugada;
                    System.out.println("\nMáquina jugó la carta: " + cartaActual);
                    if (maquina.mano.getMazo().isEmpty()) {
                        System.out.println("¡Máquina "+ " gana!");
                        continuar = false;
                    }
                } else {
                    System.out.println(maquina.nombre + " no puede jugar. Roba una carta.");

                    deckjuego.repartirCartas(maquina,1);
                }
                turnoactual++;
                if(deckjuego.getMazo().size()==0){
                    System.out.println("Empate, ya no hay cartas en el mazo");
                    continuar = false;
                }
            }
        }
        s.close();
    }
}
