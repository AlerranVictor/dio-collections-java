package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProduto {
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProduto(){
        estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        estoqueProdutosMap.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos(){
        System.out.println(estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque(){
        if(!estoqueProdutosMap.isEmpty()){
            double valorTotalEstoque = 0d;
            for(Produto p : estoqueProdutosMap.values()){ // values serve apenas para pegar somente valores do Map
                valorTotalEstoque += p.getPreco() * p.getQuantidade();
            }
            return valorTotalEstoque;
        } else {
            throw new RuntimeException("O Map se encontra vazio");
        }
    }

    public Produto obterProdutoMaisCaro(){
        if(!estoqueProdutosMap.isEmpty()){
            Produto produtoMaisCaro = null;
            double maiorPreco = Double.MIN_VALUE;
            for(Produto p : estoqueProdutosMap.values()){
                if(p.getPreco() > maiorPreco){
                    maiorPreco = p.getPreco();
                    produtoMaisCaro = p;
                }
            }
            return produtoMaisCaro;
        } else {
            throw new RuntimeException("O Map se encontra vazio");
        }
    }

    public Produto obterProdutoMaisBarato(){
        if(!estoqueProdutosMap.isEmpty()){
            Produto produtoMaisBarato = null;
            double menorPreco = Double.MAX_VALUE;
            for(Produto p : estoqueProdutosMap.values()){
                if(p.getPreco() < menorPreco){
                    menorPreco = p.getPreco();
                    produtoMaisBarato = p;
                }
            }
            return produtoMaisBarato;
        } else {
            throw new RuntimeException("O Map se encontra vazio");
        }
    }

    public static void main(String[] args) {
        EstoqueProduto estoqueProduto = new EstoqueProduto();
        estoqueProduto.adicionarProduto(1L, "Produto 1", 10, 1.00);
        estoqueProduto.adicionarProduto(2L, "Produto 2", 5, 5.75);
        estoqueProduto.adicionarProduto(3L, "Produto 3", 7, 50.13);
        estoqueProduto.adicionarProduto(6L, "Produto 4", 9, 4.32);

        estoqueProduto.exibirProdutos();
        System.out.println(estoqueProduto.calcularValorTotalEstoque());
        System.out.println(estoqueProduto.obterProdutoMaisCaro());
        System.out.println(estoqueProduto.obterProdutoMaisBarato());
    }
}
