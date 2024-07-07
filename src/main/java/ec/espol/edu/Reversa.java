package ec.espol.edu;

public class Reversa extends Carta {
    public Reversa(Color color) {
        super(color);
    }

    @Override
    public boolean puedeJugar(Carta otraCarta) {
        return otraCarta.getColor() == this.color || otraCarta instanceof Reversa;
    }
    @Override
    public String toString() {
        return " CartaEspecial [signo= ^ , color: "+ color+"]";
    }
}
