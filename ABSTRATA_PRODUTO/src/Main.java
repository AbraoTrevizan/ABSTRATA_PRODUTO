import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// classe Produto
class Produto {
    String nome;
    double precoCusto;
    double precoVenda;

    public Produto(String nome, double precoCusto, double precoVenda) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
    }

    // metodo que calcula o lucro 
    public double calcularLucro() {
        return precoVenda - precoCusto;
    }
}

// classe produtoAlimenticio
class ProdutoAlimenticio extends Produto {
    String dataValidade;
    String informacoesNutricionais;

    public ProdutoAlimenticio(String nome, double precoCusto, double precoVenda, String dataValidade, String informacoesNutricionais) {
        super(nome, precoCusto, precoVenda);
        this.dataValidade = dataValidade;
        this.informacoesNutricionais = informacoesNutricionais;
    }
}

// classe ProdutoVestuario
class ProdutoVestuario extends Produto {
    String tamanho;
    String cor;
    String material;

    public ProdutoVestuario(String nome, double precoCusto, double precoVenda, String tamanho, String cor, String material) {
        super(nome, precoCusto, precoVenda);
        this.tamanho = tamanho;
        this.cor = cor;
        this.material = material;
    }
}

// classe que e a principal
public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1. Adicionar Produto Alimentício");
            System.out.println("2. Adicionar Produto de Vestuário");
            System.out.println("3. Listar Produtos");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // pula uma linha 

            if (opcao == 1) {
                // vai estar fazendo perguntas sobre o produto alimenticio
                System.out.println("Digite o nome do produto alimenticio:");
                String nome = scanner.nextLine();
                System.out.println("Digite o preço de custo:");
                double precoCusto = scanner.nextDouble();
                System.out.println("Digite o preço de venda:");
                double precoVenda = scanner.nextDouble();
                scanner.nextLine(); 
                System.out.println("Digite a data de validade (YYYY-MM-DD):");
                String dataValidade = scanner.nextLine();
                System.out.println("Digite as informações nutricionais:");
                String informacoesNutricionais = scanner.nextLine();

                ProdutoAlimenticio produtoAlim = new ProdutoAlimenticio(nome, precoCusto, precoVenda, dataValidade, informacoesNutricionais);
                produtos.add(produtoAlim);
                System.out.println("Produto alimentício adicionado com lucro: " + produtoAlim.calcularLucro());

            } else if (opcao == 2) {
                // vai estar fazendo perguntas sobre o produto de vestuario
                System.out.println("Digite o nome do produto de vestuario:");
                String nome = scanner.nextLine();
                System.out.println("Digite o preço de custo:");
                double precoCusto = scanner.nextDouble();
                System.out.println("Digite o preço de venda:");
                double precoVenda = scanner.nextDouble();
                scanner.nextLine(); // Consumir nova linha
                System.out.println("Digite o tamanho:");
                String tamanho = scanner.nextLine();
                System.out.println("Digite a cor:");
                String cor = scanner.nextLine();
                System.out.println("Digite o material:");
                String material = scanner.nextLine();

                ProdutoVestuario produtoVest = new ProdutoVestuario(nome, precoCusto, precoVenda, tamanho, cor, material);
                produtos.add(produtoVest);
                System.out.println("Produto de vestuario adicionado com lucro: " + produtoVest.calcularLucro());

            } else if (opcao == 3) {
                // mostra a lista de produtos se esolher a opçao 3
                System.out.println("Produtos cadastrados:");
                for (Produto produto : produtos) {
                    System.out.println("Nome: " + produto.nome + ", Lucro: " + produto.calcularLucro());
                }

            } else if (opcao == 4) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção invalida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
