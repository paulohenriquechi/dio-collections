package set;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class MetodosSet {
    public static void main(String[] args) {
        //criando lista
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas.toString());

        //pesquisando um determinado valor
        System.out.println(notas.contains(5d));

        //exibindo menor valor
        System.out.println(Collections.min(notas));

        //exibindo maior valor
        System.out.println(Collections.max(notas));

        //somando os valores
        double count = 0;
        Iterator<Double> soma = notas.iterator();
        while(soma.hasNext()){
            double a = soma.next();
            count += a;
        }
        System.out.println(count);

        //media dos valores
        System.out.println(count/notas.size());

        //removendo um valor
        notas.remove(0d);
        System.out.println(notas);

        //removendo valores com base em condição
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            double next = iterator1.next();
            if(next<7){
                iterator1.remove();
            }
        }
        System.out.println(notas);

        //criando e mostrando uma lista na ordem informada
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);
        System.out.println(notas2);

        //criando e mostrando uma lista em ordem crescente
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        //apagando uma lista
        notas3.clear();

        //mostrando se a lista está vazia
        System.out.println(notas3.isEmpty()); 
    }
}
