import java.util.Scanner;

public class Main {
    private static Teatro teatro = new Teatro();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarEspetaculo();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    comprarEntradas();
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 4);

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n*** MACK THEATHER ***");
        System.out.println("1) Cadastrar Espetáculo");
        System.out.println("2) Cadastrar Cliente");
        System.out.println("3) Compra de Entradas");
        System.out.println("4) Sair");
        System.out.print("Selecione uma opção: ");
    }

    private static void cadastrarEspetaculo() {
        System.out.println("\n*** CADASTRO DE ESPETÁCULO ***");
        System.out.print("Nome do Espetáculo: ");
        String nome = scanner.nextLine();
        System.out.print("Data: ");
        String data = scanner.nextLine();
        System.out.print("Hora: ");
        String hora = scanner.nextLine();
        System.out.print("Preço da Entrada Inteira: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); 

        teatro.cadastrarEspetaculo(nome, data, hora, preco);
        System.out.println(">>> Retornar ao menu principal <<<");
    }

    private static void cadastrarCliente() {
        System.out.println("\n*** CADASTRO DE CLIENTE ***");
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        teatro.cadastrarCliente(nome, cpf);
        System.out.println(">>> Retornar ao menu principal <<<");
    }

    private static void comprarEntradas() {
        if (!teatro.hasEspetaculos()) {
            System.out.println("\nNão há espetáculos cadastrados para venda.");
            System.out.println(">>> Retornar ao menu principal <<<");
            return;
        }

        teatro.novaCompra();
        teatro.apresentaEspetaculos();
        System.out.print("Selecione um espetáculo: ");
        int numEspetaculo = scanner.nextInt();
        scanner.nextLine();

        teatro.selecionaEspetaculo(numEspetaculo);
        Espetaculo espetaculoEscolhido = teatro.getEspetaculoSelecionado();

        if (espetaculoEscolhido == null) {
            System.out.println("Espetáculo inválido.");
            System.out.println(">>> Retornar ao menu principal <<<");
            return;
        }

        while (true) {
            espetaculoEscolhido.apresentaAssentos();

            System.out.print("Selecione um assento: ");
            int assento = scanner.nextInt();

            System.out.println("||| Tipos de Entrada |||");
            System.out.println("1) Inteira");
            System.out.println("2) Meia");
            System.out.println("3) Professor");
            System.out.print("Selecione um tipo de entrada: ");
            int tipoEntrada = scanner.nextInt();
            scanner.nextLine();

            boolean sucesso = teatro.novaEntrada(tipoEntrada, assento);

            if (sucesso) {
                System.out.println("Entrada adicionada ao carrinho.");
            } else {
                System.out.println("Não foi possível adicionar a entrada. Tente novamente.");
            }

            System.out.print("Deseja comprar outra entrada (S/N)? ");
            String resposta = scanner.nextLine(); 

            if (!resposta.equalsIgnoreCase("S")) {
                break; 
            }
        }

        System.out.print("Informe o CPF do Cliente Cadastrado: ");
        String cpf = scanner.nextLine();

        double total = teatro.finalizaCompra(cpf);

        if (total < 0) {
            System.out.println("Cliente não encontrado. A venda não pode ser finalizada.");
        } else {
            System.out.printf("Valor Total: R$ %.2f\n", total);
        }
        
        System.out.println(">>> Retornar ao menu principal <<<");
    }
}