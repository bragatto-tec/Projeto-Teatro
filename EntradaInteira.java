public class EntradaInteira extends Entrada {

    public EntradaInteira(Espetaculo espetaculo, int numeroAssento) {
        super(espetaculo, numeroAssento);
    }

    @Override
    public double calculaValor() {
        return getEspetaculo().getPreco();
    }
}