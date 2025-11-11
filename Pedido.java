//Guilherme Miyamoto Bragatto - 10736124
//Pedro Henrique Lopes Sabainsk -10735777
import java.util.ArrayList;

public class Pedido {
    private ArrayList<Entrada> entradas;

    public Pedido() {
        this.entradas = new ArrayList<>();
    }

    public void adicionaEntrada(Entrada entrada) {
        this.entradas.add(entrada);
    }

    public double calculaValorTotal() {
        double total = 0.0;
        for (Entrada entrada : this.entradas) {
            total += entrada.calculaValor(); 
        }
        return total;
    }
}
