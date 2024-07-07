package ec.espol.edu;

public class CartaNormal extends Carta {
    protected int numero;

    public CartaNormal(int numero, Color color) {
        super(color);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public boolean puedeJugar(Carta otraCarta) {
        if (otraCarta instanceof CartaNormal) {
            CartaNormal otraCartaNormal = (CartaNormal) otraCarta;
            return otraCartaNormal.getColor() == this.color || otraCartaNormal.getNumero() == this.numero;
        }
        return otraCarta.getColor() == this.color;
    }

    @Override
    public String toString() {
        return " CartaNormal [numero=" + numero + ", color=" + color + "]";
    }
}
