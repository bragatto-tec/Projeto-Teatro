import java.util.ArrayList;

public class Teatro {
    private ArrayList<Espetaculo> espetaculos;
    private ArrayList<Cliente> clientes;
    private Pedido carrinho;
    private Espetaculo espetaculoSelecionado;

    public Teatro() {
        this.espetaculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.carrinho = null;
        this.espetaculoSelecionado = null;
    }

    public void cadastrarEspetaculo(String nome, String data, String hora, double preco) {
        Espetaculo novoEspetaculo = new Espetaculo(nome, data, hora, preco);
        this.espetaculos.add(novoEspetaculo);
    }

    public void cadastrarCliente(String nome, String cpf) {
        if (buscarClientePorCpf(cpf) == null) {
            Cliente novoCliente = new Cliente(nome, cpf);
            this.clientes.add(novoCliente);
            System.out.println("Cliente cadastrado!");
        } else {
            System.out.println("CPF já cadastrado no sistema.");
        }
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : this.clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public void apresentaEspetaculos() {
        System.out.println("*** VENDA DE ENTRADAS ESPETÁCULOS ***");
        if (espetaculos.isEmpty()) {
            System.out.println("Nenhum espetáculo cadastrado.");
        } else {
            for (int i = 0; i < espetaculos.size(); i++) {
                System.out.println((i + 1) + ") " + espetaculos.get(i).toString());
            }
        }
    }

    public boolean hasEspetaculos() {
        return !espetaculos.isEmpty();
    }

    public void novaCompra() {
        this.carrinho = new Pedido();
        this.espetaculoSelecionado = null;
    }

    public void selecionaEspetaculo(int numero) {
        int indice = numero - 1;
        if (indice >= 0 && indice < espetaculos.size()) {
            this.espetaculoSelecionado = this.espetaculos.get(indice);
        } else {
            this.espetaculoSelecionado = null;
        }
    }

    public Espetaculo getEspetaculoSelecionado() {
        return this.espetaculoSelecionado;
    }

    public boolean novaEntrada(int tipo, int assento) {
        if (this.espetaculoSelecionado == null) {
            System.out.println("Nenhum espetáculo foi selecionado.");
            return false;
        }

        Entrada entrada = this.espetaculoSelecionado.novaEntrada(tipo, assento);

        if (entrada != null) {
            this.carrinho.adicionaEntrada(entrada);
            return true;
        } else {
            return false;
        }
    }

    public double finalizaCompra(String cpf) {
        Cliente cliente = buscarClientePorCpf(cpf);
        if (cliente == null) {
            return -1; 
        }

        cliente.adicionaPedido(this.carrinho);
        double valorTotal = this.carrinho.calculaValorTotal();

        this.carrinho = null;
        this.espetaculoSelecionado = null;

        return valorTotal;
    }
}