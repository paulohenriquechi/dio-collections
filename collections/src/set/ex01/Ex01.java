package set.ex01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Ex01 {
    public static void main(String[] args) {
        Set<ArcoIris> arcoIris = new LinkedHashSet<>(){{
            add(new ArcoIris("Vermelho"));
            add(new ArcoIris("Laranja"));
            add(new ArcoIris("Amarelo"));
            add(new ArcoIris("Verde"));
            add(new ArcoIris("Azul"));
            add(new ArcoIris("Azul-Escuro"));
            add(new ArcoIris("Violeta"));
        }};
        System.out.println("\nCores do Arco Iris: ");
        for (ArcoIris cores : arcoIris) {
            System.out.println(cores);
        }

        System.out.println("\nQuantidade de cores do Arco Iris: "+arcoIris.size());

        Set<ArcoIris> arcoIrisAlfa = new TreeSet<>(new ComparatorLetra());
        arcoIrisAlfa.addAll(arcoIris);
        System.out.println("\nCores do Arco Iris em Ordem Alfabética: ");
        for (ArcoIris cores : arcoIrisAlfa) {
            System.out.println(cores);
        }
        
        List<ArcoIris> arcoIrisReverso = new ArrayList<>();
        arcoIrisReverso.addAll(arcoIris);
        Collections.reverse(arcoIrisReverso);
        System.out.println("\nCores do Arco Iris em Ordem Reversa");
        for (ArcoIris corReversa : arcoIrisReverso) {
            System.out.println(corReversa);
        }
        
        System.out.println("\nCores do Arco Iris que começam com a letra V: ");
        for (ArcoIris letraV : arcoIris) {
            if(letraV.toString().contains("V")){
                System.out.println("Começa com V: "+letraV);
            }
        }
        Iterator<ArcoIris> removerV = arcoIris.iterator();
        System.out.println("\nRemovendo Cores que nao começam com a letra V: ");
        while(removerV.hasNext()){
            ArcoIris next = removerV.next();
            if(!(next.toString().contains("V"))){
                System.out.println(next);
                removerV.remove();
            }
            
        }
        System.out.println("\nCores Restantes: ");
        for (ArcoIris letrasRestantes : arcoIris) {
            System.out.println(letrasRestantes);
        }

        System.out.println("\nApagando Arco Iris...");
        arcoIris.clear();

        System.out.println("\nConjunto vazio? : "+arcoIris.isEmpty());

    }
}
class ArcoIris{
    private String cor;

    public ArcoIris(String cor) {
        this.cor = cor;
    }
    public String getCor() {
        return cor;
    }
    
    public void setCor(String cor) {
        this.cor = cor;
    }
    
    @Override
    public String toString() {
        return cor;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cor == null) ? 0 : cor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ArcoIris other = (ArcoIris) obj;
        if (cor == null) {
            if (other.cor != null)
                return false;
        } else if (!cor.equals(other.cor))
            return false;
        return true;
    }



}
class ComparatorLetra implements Comparator<ArcoIris>{

    @Override
    public int compare(ArcoIris o1, ArcoIris o2) {
        return o1.getCor().compareToIgnoreCase(o2.getCor());
        

    }

}
