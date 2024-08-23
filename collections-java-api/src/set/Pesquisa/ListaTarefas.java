package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    Set<Tarefa> tarefaSet;

    public ListaTarefas(){
        tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaSet.add(new Tarefa(descricao));
    }
    public void removerTarefa(String descricao){
        if(!tarefaSet.isEmpty()){
            for(Tarefa t : tarefaSet){
                if(t.getDescricao().equalsIgnoreCase(descricao)){
                    tarefaSet.remove(t);
                    break;
                }
            }
        } else {
            System.out.println("O Set se encontra vazio");
        }
    }
    public void exibirTarefas(){
        System.out.println(tarefaSet);
    }
    public int contarTarefas(){
        return tarefaSet.size();
    }
    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if(!tarefaSet.isEmpty()){
            for(Tarefa t : tarefaSet){
                if(t.isConcluida()){
                    tarefasConcluidas.add(t);
                }
            }
            return tarefasConcluidas;
        } else {
            throw new RuntimeException("O Set se encontra vazio");
        }
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        if(!tarefaSet.isEmpty()){
            for(Tarefa t : tarefaSet){
                if(!t.isConcluida()){
                    tarefasPendentes.add(t);
                }
            }
            return tarefasPendentes;
        } else {
            throw new RuntimeException("O Set se encontra vazio");
        }
    }

//    public void marcarTarefaConcluida(String descricao){
//        if(!tarefaSet.isEmpty()){
//            for(Tarefa t : tarefaSet){
//                if(t.getDescricao().equalsIgnoreCase(descricao)){
//                    if(!t.isConcluida()){
//                        t.setConcluida();
//                    }
//                }
//            }
//        } else {
//            System.out.println("O Set se encontra vazio");
//        }
//    }

    public void marcarTarefaConcluida(String descricao){
        if(!tarefaSet.isEmpty()){
            for(Tarefa t : tarefaSet){
                if(t.getDescricao().equalsIgnoreCase(descricao) && !t.isConcluida()){
                    t.setConcluida();
                    break;
                }
            }
        } else {
            System.out.println("O Set se encontra vazio");
        }
    }


    public void marcarTarefaPendente(String descricao){
        if(!tarefaSet.isEmpty()){
            for(Tarefa t : tarefaSet){
                if(t.getDescricao().equalsIgnoreCase(descricao) && t.isConcluida()){
                    t.setPendente();
                    break;
                }
            }
        } else {
            System.out.println("O Set se encontra vazio");
        }
    }

    public void limparListaTarefa(){
        Set<Tarefa> listaRemovida = tarefaSet;
        tarefaSet.removeAll(listaRemovida);
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();
        listaTarefas.adicionarTarefa("Tarefa 1");
        listaTarefas.adicionarTarefa("Tarefa 2");
        listaTarefas.adicionarTarefa("Tarefa 3");
        listaTarefas.adicionarTarefa("Tarefa 4");

        System.out.println(listaTarefas.contarTarefas());

        listaTarefas.marcarTarefaPendente("Tarefa 1");
        listaTarefas.marcarTarefaConcluida("Tarefa 2");
        listaTarefas.marcarTarefaConcluida("Tarefa 3");
        listaTarefas.marcarTarefaPendente("Tarefa 4");

        listaTarefas.exibirTarefas();

        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.println(listaTarefas.obterTarefasPendentes());
        listaTarefas.removerTarefa("Tarefa 1");
        listaTarefas.exibirTarefas();

        listaTarefas.limparListaTarefa();
    }
}
