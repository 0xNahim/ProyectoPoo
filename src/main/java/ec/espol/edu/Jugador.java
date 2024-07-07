package ec.espol.edu;



public class Jugador {
    protected String nombre;
    protected Deck mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano= new Deck();
    }

    public Carta jugarCarta(int indice) {
        return this.mano.getMazo().remove(indice);
    }

    public void recibirCarta(Carta carta) {
        this.mano.getMazo().add(carta);
    }

    public int getNumeroCartas() {
        return this.mano.getMazo().size();
    }

    @Override
    public String toString() {
        return "Jugador [nombre=" + nombre + ", mano=" + mano.getMazo()+ "]";
    }
}