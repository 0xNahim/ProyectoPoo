package ec.espol.edu;

public class Bloqueo extends Carta {
    public Bloqueo(Color color) {
        super(color);
    }

    @Override
    public boolean puedeJugar(Carta otraCarta) {
        return otraCarta.getColor() == this.color || otraCarta instanceof Bloqueo;
    }
    @Override
    public String toString() {
        return " CartaEspecial [signo= &, color: "+ color+"]";
    }
}
