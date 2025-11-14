public class EntradaProfessor extends Entrada {

    public EntradaProfessor(Espetaculo espetaculo, int numeroAssento) {
        super(espetaculo, numeroAssento);
    }

    @Override
    public double calculaValor() {
        return getEspetaculo().getPreco() * 0.4; 
    }
}