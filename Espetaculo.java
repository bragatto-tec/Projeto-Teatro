//Guilherme Miyamoto Bragatto - 10736124
//Pedro Henrique Lopes Sabainsk -10735777
public class Espetaculo {
    private String nome;
    private String data;
    private String hora;
    private double preco;
    private boolean[] assentos;

    public Espetaculo(String nome, String data, String hora, double preco) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
        this.assentos = new boolean[50]; 
    }

    public double getPreco() {
        return preco;
    }

    private boolean isAssentoOcupado(int numeroAssento) {
        if (numeroAssento < 1 || numeroAssento > 50) {
            return true;
        }
        return this.assentos[numeroAssento - 1];
    }

    private void marcarAssento(int numeroAssento) {
        if (numeroAssento >= 1 && numeroAssento <= 50) {
            this.assentos[numeroAssento - 1] = true;
        }
    }

    public Entrada novaEntrada(int tipo, int assento) {
        if (isAssentoOcupado(assento)) {
            System.out.println("Assento " + assento + " já está ocupado ou inválido.");
            return null;
        }

        marcarAssento(assento);
        Entrada novaEntrada = null;

        switch (tipo) {
            case 1:
                novaEntrada = new EntradaInteira(this, assento);
                break;
            case 2:
                novaEntrada = new EntradaMeia(this, assento);
                break;
            case 3:
                novaEntrada = new EntradaProfessor(this, assento);
                break;
            default:
                System.out.println("Tipo de entrada inválido.");
                this.assentos[assento - 1] = false;
                return null;
        }
        
        return novaEntrada;
    }

    public void apresentaAssentos() {
        System.out.println("||| Assentos Disponíveis |||");
        for (int i = 4; i >= 0; i--) {
            for (int j = 9; j >= 0; j--) {
                int numeroAssento = i * 10 + j + 1;
                if (assentos[numeroAssento - 1]) {
                    System.out.print("XX ");
                } else {
                    System.out.printf("%02d ", numeroAssento);
                }
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %s R$ %.2f", this.nome, this.data, this.hora, this.preco);
    }
}