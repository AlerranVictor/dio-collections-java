package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> palavras;

    public ContagemPalavras(){
        palavras = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem){
        palavras.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        if(!palavras.isEmpty()){
            palavras.remove(palavra);
        } else {
            System.out.println("Map vazio");
        }
    }

    public int exibirContagemPalavras(){
        if(!palavras.isEmpty()){
            int contagemTotal = 0;
            for(int contagem : palavras.values()){
                contagemTotal =+ contagem;
            }
            return contagemTotal;
        } else {
            throw new RuntimeException("Map vazio");
        }
    }

    public String encontrarPalavraMaisFrequente(){
        if(!palavras.isEmpty()){
            String palavraMaisFrequente = null;
            int maiorContagem = 0;
            for(Map.Entry<String, Integer> entry : palavras.entrySet()){
                if(entry.getValue() > maiorContagem){
                    maiorContagem = entry.getValue();
                    palavraMaisFrequente = entry.getKey();
                }
            }
            return palavraMaisFrequente;
        } else {
            throw new RuntimeException("Map vazio");
        }
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();
        contagemPalavras.adicionarPalavra("Amanhã", 10);
        contagemPalavras.adicionarPalavra("Ontem", 9);
        contagemPalavras.adicionarPalavra("Semana", 7);
        contagemPalavras.adicionarPalavra("Mês", 31);

        System.out.println(contagemPalavras.exibirContagemPalavras());

        contagemPalavras.removerPalavra("Mês");

        System.out.println(contagemPalavras.encontrarPalavraMaisFrequente());
    }
}
