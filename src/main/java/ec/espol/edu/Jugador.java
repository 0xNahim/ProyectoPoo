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

    protected void imprimirMano() {
        for (int i = 0; i < mano.getMazo().size(); i++) {
            System.out.print(" " + (i + 1) + " " + mano.getMazo().get(i));
            if ((i + 1) % 3 == 0 || i == mano.getMazo().size() - 1) {
                System.out.println();
            } else {
                System.out.print(" | ");
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Jugador [nombre=" + nombre + ", mano=" + mano.getMazo()+ "]";
    }
    

}