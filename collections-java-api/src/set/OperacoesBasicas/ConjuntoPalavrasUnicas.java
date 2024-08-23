package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    Set<String> palavrasUnicasSet;

    public ConjuntoPalavrasUnicas(){
        palavrasUnicasSet = new HashSet<>();
    }

    @Override
    public String toString() {
        return "ConjuntoPalavrasUnicas{" +
                "palavrasUnicasSet=" + palavrasUnicasSet +
                '}';
    }

    public void adicionarPalavra(String palavra){
        palavrasUnicasSet.add(palavra);
    }

    public void removerPalavra(String palavra){
        if(palavrasUnicasSet.contains(palavra)){
            palavrasUnicasSet.remove(palavra);
        } else{
            System.out.println("A palavra não foi encontrada");
        }
    }

    public String verificarPalavra(String palavra){
        if(palavrasUnicasSet.contains(palavra)){
            return "A palavra: (" + palavra + ") está presente no Set de Palavras";
        } else{
            throw new RuntimeException("A palavra não foi encontrada no Set de Palavras");
        }
    }

    public void exibirPalavrasUnicas(){
        System.out.println(palavrasUnicasSet);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();
        conjuntoPalavrasUnicas.adicionarPalavra("Palavra");
        conjuntoPalavrasUnicas.adicionarPalavra("Verbo");
        conjuntoPalavrasUnicas.adicionarPalavra("Adjetivo");
        conjuntoPalavrasUnicas.adicionarPalavra("Substantivo");
        conjuntoPalavrasUnicas.adicionarPalavra("Adverbio");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        conjuntoPalavrasUnicas.removerPalavra("Palavra");
        conjuntoPalavrasUnicas.exibirPalavrasUnicas();
        System.out.println(conjuntoPalavrasUnicas.verificarPalavra("Verbo"));
    }
}
