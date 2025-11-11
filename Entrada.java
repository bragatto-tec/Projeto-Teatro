//Guilherme Miyamoto Bragatto - 10736124
//Pedro Henrique Lopes Sabainsk -10735777
public abstract class Entrada {
    private Espetaculo espetaculo;
    private int numeroDoAssento;

    public Entrada(Espetaculo espetaculo, int numeroAssento) {
        this.espetaculo = espetaculo;
        this.numeroDoAssento = numeroAssento;
    }

    public Espetaculo getEspetaculo() {
        return espetaculo;
    }

    public int getNumeroDoAssento() {
        return numeroDoAssento;
    }

    public abstract double calculaValor();
}
