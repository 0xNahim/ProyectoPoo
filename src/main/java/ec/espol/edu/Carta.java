package ec.espol.edu;

public abstract class Carta {
    protected Color color;
    public Carta(){}
    public Carta(Color color) {
        if(color!=Color.N){
            this.color = color;
        }
        
    }

    public Color getColor() {
        return color;
    }

    public abstract boolean puedeJugar(Carta otraCarta);
}
