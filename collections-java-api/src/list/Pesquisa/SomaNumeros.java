package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> numeros;

    public SomaNumeros(){
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        numeros.add(numero);
    }

    public int calcularSoma(){
        int soma = 0;
        for(Integer i : numeros){
            soma += i;
        }
        return soma;
    }

    public int encontrarMaiorNumero(){
        int maiorNumero = Integer.MIN_VALUE;
        if(!numeros.isEmpty()){
            for(Integer i : numeros){
                if(i > maiorNumero){
                    maiorNumero = i;
                }
            }
            return maiorNumero;
        } else {
            throw new RuntimeException("A lista está vazia");
        }
    }

    public int encontrarMenorNumero(){
        int menorNumero = Integer.MAX_VALUE;
        if(!numeros.isEmpty()){
            for(Integer i : numeros){
                if(i < menorNumero){
                    menorNumero = i;
                }
            }
            return menorNumero;
        } else {
            throw new RuntimeException("A lista está vazia");
        }
    }

    public void exibirNumeros(){
        if(!numeros.isEmpty()){
            System.out.println(this.numeros);
        } else {
            System.out.println("A lista está vazia");
        }
    }


    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(9);
        somaNumeros.adicionarNumero(15);
        somaNumeros.adicionarNumero(17);
        somaNumeros.adicionarNumero(42);

        System.out.println(somaNumeros.calcularSoma());
        System.out.println(somaNumeros.encontrarMaiorNumero());
        System.out.println(somaNumeros.encontrarMenorNumero());
        somaNumeros.exibirNumeros();
    }
}
