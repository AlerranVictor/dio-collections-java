package map.Ordenacao;

import jdk.jfr.Event;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos(){
        eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        eventosMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap); /* LocalDate "indiretamente" implementa
        Comparable, por isso o código funciona. Isso faz com que o Map fique em ordem crescente */
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento(){
        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        for(Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()){
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                System.out.println("O evento " + entry.getValue() + " acontecerá na data " + entry.getKey());
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.DECEMBER, 22), "Evento 1", "Atração 1");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 3, 25), "Evento 2", "Atração 2");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 5, 22), "Evento 3", "Atração 3");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.JANUARY, 1), "Evento 4", "Atração 4");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.NOVEMBER, 5), "Evento 5", "Atração 5");

        agendaEventos.obterProximoEvento();

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();
    }


}
