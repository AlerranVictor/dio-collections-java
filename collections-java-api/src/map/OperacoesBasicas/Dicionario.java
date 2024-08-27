package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionario;

    public Dicionario (){
        dicionario = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao){
        dicionario.put(palavra, definicao);
    }
    public void removerPalavra(String palavra){
        if(!dicionario.isEmpty()){
            dicionario.remove(palavra);
        } else {
            System.out.println("Map vazio");
        }
    }
    public void exibirPalavras(){
        if(!dicionario.isEmpty()){
            System.out.println(dicionario);
        } else {
            System.out.println("Map vazio");
        }
    }
    public String pesquisarPorPalavra(String palavra){
        if(!dicionario.isEmpty()){
            return dicionario.get(palavra);
        } else{
            throw new RuntimeException("Map vazio");
        }
    }

    public static void main(String[] args) {
        Dicionario dicionario1 = new Dicionario();
        dicionario1.adicionarPalavra("Palavra 1", "Definição 1");
        dicionario1.adicionarPalavra("Palavra 2", "Definição 2");
        dicionario1.adicionarPalavra("Palavra 3", "Definição 3");
        dicionario1.adicionarPalavra("Palavra 4", "Definição 4");

        System.out.println(dicionario1.pesquisarPorPalavra("Palavra 2"));

        dicionario1.removerPalavra("Palavra 2");

        dicionario1.exibirPalavras();
    }

}
