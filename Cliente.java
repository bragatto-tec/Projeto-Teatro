//Guilherme Miyamoto Bragatto - 10736124
//Pedro Henrique Lopes Sabainsk -10735777
import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Pedido> pedidos;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.pedidos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void adicionaPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
}