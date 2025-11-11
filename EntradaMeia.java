//Guilherme Miyamoto Bragatto - 10736124
//Pedro Henrique Lopes Sabainsk -10735777
public class EntradaMeia extends Entrada {

    public EntradaMeia(Espetaculo espetaculo, int numeroAssento) {
        super(espetaculo, numeroAssento);
    }

    @Override
    public double calculaValor() {
        return getEspetaculo().getPreco() * 0.5;
    }
}