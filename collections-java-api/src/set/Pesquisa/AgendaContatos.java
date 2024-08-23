package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos(){
        contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero){
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos(){
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatosPorNome = new HashSet<>();
        if(!contatoSet.isEmpty()){
            for(Contato c : contatoSet){
                if(c.getNome().startsWith(nome)){
                    contatosPorNome.add(c);
                }
            }
            return contatosPorNome;
        } else {
            throw new RuntimeException("A AgendaContatos está vazia");
        }
    }

    public Contato atualizarNumeroContato(String nome, int numero){
        if(!contatoSet.isEmpty()){
            Contato contatoAtualizado = null;
            for(Contato c : contatoSet){
                if(c.getNome().equalsIgnoreCase(nome)){
                    c.setNumeroTelefone(numero);
                    contatoAtualizado = c;
                    break;
                }
            }
            return contatoAtualizado;
        } else {
            throw new RuntimeException("A AgendaContatos está vazia");
        }
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();
        agendaContatos.adicionarContato("Contato 1", 123456789);
        agendaContatos.adicionarContato("Contato 2", 123456799);
        agendaContatos.adicionarContato("Contato 3", 123456799);
        agendaContatos.adicionarContato("Contato 4", 123456889);

        agendaContatos.exibirContatos();

        System.out.println(agendaContatos.atualizarNumeroContato("Contato 1", 123456788));

        agendaContatos.exibirContatos();

        System.out.println(agendaContatos.pesquisarPorNome("Contato 1"));
        System.out.println(agendaContatos.pesquisarPorNome("Contato"));
    }
}
