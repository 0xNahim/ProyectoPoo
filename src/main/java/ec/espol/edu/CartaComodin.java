package ec.espol.edu;

public abstract class CartaComodin extends Carta{
    protected String tipo;

    public CartaComodin(){
    }

    public CartaComodin(Color color){
        this.color = color;
    }

    
    public abstract boolean puedeJugar(Carta otraCarta);

    @Override
    public String toString() {
        return " CartaEspecial [signo="+tipo+", color="+ color+"]";
    }



}
