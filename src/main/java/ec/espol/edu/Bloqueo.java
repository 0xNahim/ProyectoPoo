package ec.espol.edu;

public class Bloqueo extends CartaComodin {
    public Bloqueo(Color color) {
        super(color);
        this.tipo = "&";
    }

    @Override
    public boolean puedeJugar(Carta otraCarta) {
        return otraCarta.getColor().equals(this.color) || otraCarta instanceof Bloqueo;
    }
}
