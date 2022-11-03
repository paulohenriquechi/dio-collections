package lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MetodosList {
    public static void main(String[] args) {
        List<Double> notas = new ArrayList<>();
        // adiciona items ao array
            notas.add(7.0);
            notas.add(8.5);
            notas.add(9.3);
            notas.add(5.0);
            notas.add(7.0);
            notas.add(0.0);
            notas.add(3.6);
            System.out.println(notas);
        //retorna posição do item no array
            System.out.println(notas.indexOf(5.0));
        //adiciona um item na posição indicada no array, empurrando o resto pra frente
            notas.add(4, 8.0);
            System.out.println(notas);
        //remove o item do array **
            notas.remove(5.0);
            System.out.println(notas);
        //substitui o item do array na posição pelo informado
            notas.set(3, 6.0);
            System.out.println(notas);
        //utilizando indexOf e set
            notas.set(notas.indexOf(9.3), 6.5);
            System.out.println(notas);
        //busca um número na lista e retorna true ou false
            System.out.println(notas.contains(7.0));
        //imprime item a item na ordem
            // for (Double numero : notas) {
            //     System.out.println(numero);
            // }
        //retorna o numero na posição indicada do array
            System.out.println(notas.get(2));
        //busca o menor valor
            System.out.println("Menor valor da lista: "+Collections.min(notas));
        //busca o maior valor
            System.out.println("Maior valor da lista: "+Collections.max(notas));
        // soma e media
            Iterator<Double> iterator = notas.iterator();
            double soma = 0;
            while(iterator.hasNext()){
                double next = iterator.next();
                soma += next;
            }
            System.out.println(soma);
            System.out.println(soma/(notas.size()));
        // remove um determinado item
            notas.remove(0d);
            System.out.println(notas);
        // remove o item na posição dada
            notas.remove(0);
            System.out.println(notas);
        // remove valores com base em condições
            Iterator<Double> iterator1 = notas.iterator();
            while(iterator1.hasNext()){
                double next = iterator1.next();
                if(next<7){
                    iterator1.remove();
                }
            }
            System.out.println(notas);
        //apaga toda lista
            notas.clear();
            System.out.println(notas);
        //verifica se esta vazia 
            System.out.println(notas.isEmpty());
    }
}
