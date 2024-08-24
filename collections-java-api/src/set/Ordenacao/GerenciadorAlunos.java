package set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos(){
        alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, int nota){
        alunoSet.add(new Aluno(nome, matricula, nota));
    }

    public void removerAluno(long matricula){
        if(!alunoSet.isEmpty()){
            for(Aluno a : alunoSet){
                if(a.getMatricula() == matricula){
                    alunoSet.remove(a);
                    System.out.println("Matricula " + matricula + " removida com sucesso");
                    break;
                }
            }
        } else{
            System.out.println("O Set se encontra vazio");
        }
    }

    public Set<Aluno> exibirAlunosPorNome(){
        if(!alunoSet.isEmpty()){
            return new TreeSet<>(alunoSet);
        } else {
            throw new RuntimeException("O Set se encontra vazio");
        }
    }

    public Set<Aluno> exibirAlunosPorNota(){
        if(!alunoSet.isEmpty()){
            Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorNota());
            alunosPorNota.addAll(alunoSet);
            return alunosPorNota;
        } else {
            throw new RuntimeException("O Set se encontra vazio, portanto não há alunos para serem exibidos");
        }
    }

    public void exibirAlunos(){
        System.out.println(alunoSet);
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();
        gerenciadorAlunos.adicionarAluno("Aluno 1", 9L, 10);
        gerenciadorAlunos.adicionarAluno("Aluno 2", 3L, 5);
        gerenciadorAlunos.adicionarAluno("Aluno 3", 9L, 7);
        gerenciadorAlunos.adicionarAluno("Aluno 4", 1L, 1);

        gerenciadorAlunos.exibirAlunos();
        gerenciadorAlunos.removerAluno(9L);
        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());
    }

}
