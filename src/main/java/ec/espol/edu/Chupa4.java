package ec.espol.edu;

import java.util.Random;
import java.util.Scanner;

public class Chupa4 extends Carta {
    public Chupa4() {
        this.color=Color.N;
    }

    @Override
    public boolean puedeJugar(Carta otraCarta) {
        return true; // Puede jugarse en cualquier momento
    }
    public void cambiarColor() {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el color que desea cambiar: \n1.-Verde\n2.-Azul\n3.-Amarillo\n4.-Rojo");
        int c = s.nextInt();
        switch (c) {
            case 1:
                this.color = Color.V;
                break;
            case 2:
                this.color = Color.Z;
                break;
            case 3:
                this.color = Color.A;
                break;
            case 4:
                this.color = Color.R;
                break;
            default:
                System.out.println("Color no válido, elige de nuevo.");
                cambiarColor();
                break;
        }
    }
    public void cambiarColorAutomatico() {
        Random rand = new Random();
        int c = rand.nextInt(4) + 1;
        switch (c) {
            case 1:
                this.color = Color.V;
                break;
            case 2:
                this.color = Color.Z;
                break;
            case 3:
                this.color = Color.A;
                break;
            case 4:
                this.color = Color.R;
                break;
        }
    }
    @Override
    public String toString() {
        return " CartaEspecial [signo= +4, color: "+ this.color+"]";
    }
}