/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.minimercado;

/**
 *
 * @author 8261100113
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class MiniMercado {

    static Scanner sc = new Scanner(System.in);

    static Produto[] produtos = new Produto[100];
    static Cliente[] clientes = new Cliente[100];

    static int qtdProdutos = 0;
    static int qtdClientes = 0;

    public static void main(String[] args) {

        carregarProdutos();
        carregarClientes();

        int opcao;

        do {

            System.out.println("\n=================================");
            System.out.println("       MINI MERCADO");
            System.out.println("=================================");
            System.out.println("1 - Produtos");
            System.out.println("2 - Clientes");
            System.out.println("3 - Realizar Compra");
            System.out.println("4 - Controle de Estoque");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {

                case 1:
                    menuProdutos();
                    break;

                case 2:
                    menuClientes();
                    break;

                case 3:
                    realizarCompra();
                    break;

                case 4:
                    listarProdutos();
                    break;

                case 0:
                    salvarProdutos();
                    salvarClientes();
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    // ==========================
    // MENU PRODUTOS
    // ==========================

    public static void menuProdutos() {

        int op;

        do {

            System.out.println("\n===== PRODUTOS =====");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Buscar Produto");
            System.out.println("4 - Alterar Produto");
            System.out.println("5 - Remover Produto");
            System.out.println("0 - Voltar");

            System.out.print("Escolha: ");
            op = Integer.parseInt(sc.nextLine());

            switch (op) {

                case 1:
                    cadastrarProduto();
                    break;

                case 2:
                    listarProdutos();
                    break;

                case 3:
                    buscarProduto();
                    break;

                case 4:
                    alterarProduto();
                    break;

                case 5:
                    removerProduto();
                    break;
            }

        } while (op != 0);
    }

    public static void cadastrarProduto() {

        System.out.println("\nCADASTRAR PRODUTO");

        System.out.print("Código: ");
        int codigo = Integer.parseInt(sc.nextLine());

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Preço: ");
        double preco = Double.parseDouble(sc.nextLine());

        System.out.print("Estoque: ");
        int estoque = Integer.parseInt(sc.nextLine());

        produtos[qtdProdutos] =
                new Produto(codigo, nome, preco, estoque);

        qtdProdutos++;

        salvarProdutos();

        System.out.println("Produto cadastrado com sucesso!");
    }

    public static void listarProdutos() {

        System.out.println("\n===== LISTA DE PRODUTOS =====");

        if (qtdProdutos == 0) {

            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (int i = 0; i < qtdProdutos; i++) {

            System.out.println(produtos[i]);
        }
    }

    public static void buscarProduto() {

        System.out.print("Digite o código: ");
        int codigo = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < qtdProdutos; i++) {

            if (produtos[i].getCodigo() == codigo) {

                System.out.println(produtos[i]);
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    public static void alterarProduto() {

        System.out.print("Código do produto: ");
        int codigo = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < qtdProdutos; i++) {

            if (produtos[i].getCodigo() == codigo) {

                System.out.print("Novo nome: ");
                produtos[i].setNome(sc.nextLine());

                System.out.print("Novo preço: ");
                produtos[i].setPreco(
                        Double.parseDouble(sc.nextLine())
                );

                System.out.print("Novo estoque: ");
                produtos[i].setEstoque(
                        Integer.parseInt(sc.nextLine())
                );

                salvarProdutos();

                System.out.println("Produto alterado.");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    public static void removerProduto() {

        System.out.print("Código do produto: ");
        int codigo = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < qtdProdutos; i++) {

            if (produtos[i].getCodigo() == codigo) {

                for (int j = i; j < qtdProdutos - 1; j++) {

                    produtos[j] = produtos[j + 1];
                }

                qtdProdutos--;

                salvarProdutos();

                System.out.println("Produto removido.");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    } 
  
     // ==========================
    // MENU CLIENTES
    // ==========================

    public static void menuClientes() {

        int op;

        do {

            System.out.println("\n===== CLIENTES =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Buscar Cliente");
            System.out.println("4 - Alterar Cliente");
            System.out.println("5 - Remover Cliente");
            System.out.println("0 - Voltar");

            System.out.print("Escolha: ");
            op = Integer.parseInt(sc.nextLine());

            switch (op) {

                case 1:
                    cadastrarCliente();
                    break;

                case 2:
                    listarClientes();
                    break;

                case 3:
                    buscarCliente();
                    break;

                case 4:
                    alterarCliente();
                    break;

                case 5:
                    removerCliente();
                    break;
            }

        } while (op != 0);
    }

    // ==========================
    // CADASTRAR CLIENTE
    // ==========================

    public static void cadastrarCliente() {

        System.out.println("\nCADASTRAR CLIENTE");

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        clientes[qtdClientes] =
                new Cliente(cpf, nome, telefone, email);

        qtdClientes++;

        salvarClientes();

        System.out.println("Cliente cadastrado com sucesso!");
    }

    // ==========================
    // LISTAR CLIENTES
    // ==========================

    public static void listarClientes() {

        System.out.println("\n===== LISTA DE CLIENTES =====");

        if (qtdClientes == 0) {

            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        for (int i = 0; i < qtdClientes; i++) {

            System.out.println(clientes[i]);
        }
    }

    // ==========================
    // BUSCAR CLIENTE
    // ==========================

    public static void buscarCliente() {

        System.out.print("Digite o CPF: ");
        String cpf = sc.nextLine();

        for (int i = 0; i < qtdClientes; i++) {

            if (clientes[i].getCpf().equals(cpf)) {

                System.out.println(clientes[i]);
                return;
            }
        }

        System.out.println("Cliente não encontrado.");
    }

    // ==========================
    // ALTERAR CLIENTE
    // ==========================

    public static void alterarCliente() {

        System.out.print("CPF do cliente: ");
        String cpf = sc.nextLine();

        for (int i = 0; i < qtdClientes; i++) {

            if (clientes[i].getCpf().equals(cpf)) {

                System.out.print("Novo nome: ");
                clientes[i].setNome(sc.nextLine());

                System.out.print("Novo telefone: ");
                clientes[i].setTelefone(sc.nextLine());

                System.out.print("Novo email: ");
                clientes[i].setEmail(sc.nextLine());

                salvarClientes();

                System.out.println("Cliente alterado.");
                return;
            }
        }

        System.out.println("Cliente não encontrado.");
    }

    // ==========================
    // REMOVER CLIENTE
    // ==========================

    public static void removerCliente() {

        System.out.print("CPF do cliente: ");
        String cpf = sc.nextLine();

        for (int i = 0; i < qtdClientes; i++) {

            if (clientes[i].getCpf().equals(cpf)) {

                for (int j = i; j < qtdClientes - 1; j++) {

                    clientes[j] = clientes[j + 1];
                }

                qtdClientes--;

                salvarClientes();

                System.out.println("Cliente removido.");
                return;
            }
        }

        System.out.println("Cliente não encontrado.");
    }   
    // ==========================
    // REALIZAR COMPRA
    // ==========================

    public static void realizarCompra() {
        
        System.out.println("\n===== COMPRA =====");

        System.out.print("CPF do cliente: ");
        String cpf = sc.nextLine();
        String nomeCliente = "";

        boolean clienteExiste = false;

        for (int i = 0; i < qtdClientes; i++) {

            if (clientes[i].getCpf().equals(cpf)) {
                clienteExiste = true;
                nomeCliente = clientes[i].getNome();
                break;
            }
        }

        if (!clienteExiste) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        double total = 0;
        
        int[] codCarrinho = new int[100];
        String[] nomeCarrinho = new String[100];
        int[] qtdCarrinho = new int[100];
        double[] subtotalCarrinho = new double[100];

        int itensCarrinho = 0;

        while (true) {

            listarProdutos();

            System.out.print("\nCódigo do produto (-1 para finalizar): ");
            int codigo = Integer.parseInt(sc.nextLine());

            if (codigo == -1) {
                break;
            }

            System.out.print("Quantidade: ");
            int qtd = Integer.parseInt(sc.nextLine());

            boolean achou = false;

            for (int i = 0; i < qtdProdutos; i++) {

                if (produtos[i].getCodigo() == codigo) {
                    double subtotal = produtos[i].getPreco() * qtd;
            total += subtotal;

            // salvar no carrinho
            codCarrinho[itensCarrinho] = produtos[i].getCodigo();
            nomeCarrinho[itensCarrinho] = produtos[i].getNome();
            qtdCarrinho[itensCarrinho] = qtd;
            subtotalCarrinho[itensCarrinho] = subtotal;

            itensCarrinho++;

                    achou = true;

                    if (produtos[i].getEstoque() >= qtd) {
                        

                        produtos[i].setEstoque(
                                produtos[i].getEstoque() - qtd
                        );

                    } else {
                        System.out.println("Estoque insuficiente!");
                    }
                }
            }

            if (!achou) {
                System.out.println("Produto não encontrado!");
            }
        }

        salvarProdutos();

        System.out.println("\nTOTAL DA COMPRA: R$ " + total);
        System.out.println("Compra finalizada!");
        
        System.out.println("\n######## NOTA FISCAL ########");

        System.out.println("Cliente: " + nomeCliente + " (" + cpf + ")");
        System.out.println("Itens comprados registrados no sistema.");
        
        for (int i = 0; i < itensCarrinho; i++) {

    System.out.println(
        codCarrinho[i] + " - " +
        nomeCarrinho[i] +
        " | Qtd: " + qtdCarrinho[i] +
        " | Subtotal: R$ " + subtotalCarrinho[i]
    );
}

        System.out.printf("TOTAL: R$ %.2f%n", total);

        System.out.println("#############################");
    }

    // ==========================
    // SALVAR PRODUTOS CSV
    // ==========================

    public static void salvarProdutos() {

        try {

            FileWriter fw = new FileWriter("produtos.csv");

            for (int i = 0; i < qtdProdutos; i++) {

                fw.write(
                        produtos[i].getCodigo() + ";" +
                        produtos[i].getNome() + ";" +
                        produtos[i].getPreco() + ";" +
                        produtos[i].getEstoque() + "\n"
                );
            }

            fw.close();

        } catch (Exception e) {
            System.out.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }

    // ==========================
    // CARREGAR PRODUTOS CSV
    // ==========================

    public static void carregarProdutos() {

        try {

            File arquivo = new File("produtos.csv");

            if (!arquivo.exists()) return;

            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {

                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                produtos[qtdProdutos] = new Produto(
                        Integer.parseInt(dados[0]),
                        dados[1],
                        Double.parseDouble(dados[2]),
                        Integer.parseInt(dados[3])
                );

                qtdProdutos++;
            }

            leitor.close();

        } catch (Exception e) {
            System.out.println("Erro ao carregar produtos: " + e.getMessage());
        }
    }

    // ==========================
    // SALVAR CLIENTES CSV
    // ==========================

    public static void salvarClientes() {

        try {

            FileWriter fw = new FileWriter("clientes.csv");

            for (int i = 0; i < qtdClientes; i++) {

                fw.write(
                        clientes[i].getCpf() + ";" +
                        clientes[i].getNome() + ";" +
                        clientes[i].getTelefone() + ";" +
                        clientes[i].getEmail() + "\n"
                );
            }

            fw.close();

        } catch (Exception e) {
            System.out.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }

    // ==========================
    // CARREGAR CLIENTES CSV
    // ==========================

    public static void carregarClientes() {

        try {

            File arquivo = new File("clientes.csv");

            if (!arquivo.exists()) return;

            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {

                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                clientes[qtdClientes] = new Cliente(
                        dados[0],
                        dados[1],
                        dados[2],
                        dados[3]
                );

                qtdClientes++;
            }

            leitor.close();

        } catch (Exception e) {
            System.out.println("Erro ao carregar clientes: " + e.getMessage());
        }
    }
}