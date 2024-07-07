package ec.espol.edu;

import java.util.Scanner;

public class Persona extends Jugador {
    private Scanner scanner;

    public Persona(String nombre) {
        super(nombre);
        scanner = new Scanner(System.in);
    }

    public Carta jugarCarta(Carta cartaActual) {
        System.out.println("Carta actual en juego: " + cartaActual);
        System.out.println("Tu mano:");
        imprimirMano();
        System.out.print("Ingrese el índice de la carta a jugar (1 - " + (mano.getMazo().size()) + "): ");
        int indice = scanner.nextInt() - 1;
        Carta carta = mano.getMazo().get(indice);
        if (carta.puedeJugar(cartaActual)) {
            mano.getMazo().remove(indice);
            return carta;
        } else {
            System.out.println("¡Carta no válida! Debes robar una carta.");
            return null;
        }
    }

    private void imprimirMano() {
        for (int i = 0; i < mano.getMazo().size(); i++) {
            System.out.print(" " + (i + 1) + " " + mano.getMazo().get(i));
            if ((i + 1) % 3 == 0 || i == mano.getMazo().size() - 1) {
                System.out.println();
            } else {
                System.out.print(" | ");
            }
        }
    }
}