package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatosMap;

    public AgendaContatos(){
        agendaContatosMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer numero){
        agendaContatosMap.put(nome, numero);
    }

    public void removerContato(String nome){
        if(!agendaContatosMap.isEmpty()){
            agendaContatosMap.remove(nome);
        }
    }

    public void exibirContatos(){
        System.out.println(agendaContatosMap);
    }

    public Integer pesquisarPorNome(String nome){
        if(!agendaContatosMap.isEmpty()){
            return agendaContatosMap.get(nome);
        } else {
            throw new RuntimeException("O Map de contatos está vazio");
        }
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();
        agendaContatos.adicionarContato("Contato 1", 12345);
        agendaContatos.adicionarContato("Contato 2", 12346);
        agendaContatos.adicionarContato("Contato 1", 12347);
        agendaContatos.adicionarContato("Contato 4", 12348);

        agendaContatos.exibirContatos();

        agendaContatos.removerContato("Contato 1");

        agendaContatos.exibirContatos();

        System.out.println(agendaContatos.pesquisarPorNome("Contato 4"));
    }
}
