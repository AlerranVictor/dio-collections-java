package list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    private List<Pessoa> pessoaList;
    public OrdenacaoPessoas(){
        pessoaList = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura){
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade(){
        List<Pessoa> pessoaPorIdade = new ArrayList<>(pessoaList);
        Collections.sort(pessoaPorIdade);
        return pessoaPorIdade;
    }

    public List<Pessoa> ordenarPorAltura(){
        List<Pessoa> pessoaPorALtura = new ArrayList<>(pessoaList);
        Collections.sort(pessoaPorALtura, new ComparatorPorAltura());
        return pessoaPorALtura;
    }


    public static void main(String[] args) {
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();
        ordenacaoPessoas.adicionarPessoa("Nome 1", 22, 1.70);
        ordenacaoPessoas.adicionarPessoa("Nome 2", 30, 1.77);
        ordenacaoPessoas.adicionarPessoa("Nome 3", 21, 1.82);
        ordenacaoPessoas.adicionarPessoa("Nome 4", 47, 1.55);
        ordenacaoPessoas.adicionarPessoa("Nome 5", 82, 1.59);

        System.out.println(ordenacaoPessoas.ordenarPorIdade());
        System.out.println(ordenacaoPessoas.ordenarPorAltura());
    }
}
