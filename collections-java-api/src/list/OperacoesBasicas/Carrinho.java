package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Item> carrinho;

    public Carrinho(){
        this.carrinho = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        carrinho.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String itemParaRemover){
        List<Item> itensRemover = new ArrayList<>();
        for(Item t : carrinho){
            if(t.getNome().equalsIgnoreCase(itemParaRemover)){
                itensRemover.add(t);
            }
        }
        carrinho.removeAll(itensRemover);
    }

    public void calcularValorTotal(){
        double valorTotal = 0;

        for(Item i: carrinho){
            valorTotal += i.getPreco() * i.getQuantidade();
        }
        System.out.println(valorTotal);
    }

    public void exibirItens(){
        System.out.println(carrinho);
    }

    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionarItem("maçã", 2.95, 2);
        carrinho.adicionarItem("banana", 1.50, 3);
        carrinho.adicionarItem("goiaba", 1.30, 5);

        carrinho.removerItem("maçã");

        carrinho.calcularValorTotal();

        carrinho.exibirItens();
    }
}
