package ec.espol.edu;

public class Reversa extends CartaComodin {
    public Reversa(Color color) {
        super(color);
        this.tipo = "^";
    }

    @Override
    public boolean puedeJugar(Carta otraCarta) {
        return otraCarta.getColor().equals(this.color) || otraCarta instanceof Reversa;
    }
}
