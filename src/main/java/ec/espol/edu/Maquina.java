package ec.espol.edu;


public class Maquina extends Jugador {
    public Maquina(String nombre) {
        super(nombre);
    }

    public Carta jugarCarta(Carta cartaActual) {
        
        for (Carta carta : mano.getMazo()) {
            if (carta.puedeJugar(cartaActual)) {
                mano.getMazo().remove(carta);
                return carta;
            }
        }
        return null;
        
        
    }

}
