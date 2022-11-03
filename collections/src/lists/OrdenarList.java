package lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenarList {
    public static void main(String[] args) {
        List<Banda> bandas = new ArrayList<>(){{
            add(new Banda("Depeche Mode", "Eletrônica", 4));
            add(new Banda("Alice in Chains", "Grunge", 4));
            add(new Banda("The Cure", "Post Punk", 5));
        }};
        //imprime na ordem de inserção
        System.out.println(bandas);
        //imprime de ordem aleatória
        Collections.shuffle(bandas);
        System.out.println(bandas);
        //
        Collections.sort(bandas);
        System.out.println(bandas);
    }
}

class Banda implements Comparable<Banda>{
    private String nome;
    private String genero;
    private Integer integrantes;
    
    public Banda(String nome, String genero, Integer integrantes){
        this.nome = nome;
        this.genero = genero;
        this.integrantes = integrantes;
    }
    public String getNome(){
        return nome;
    }
    public String getGenero(){
        return genero;
    }
    public Integer getIntegrantes(){
        return integrantes;
    }
    
    @Override
    public String toString() {
        return nome+" "+" "+genero+" "+" "+integrantes;
    }
    @Override
    public int compareTo(Banda banda) {
        return this.getNome().compareToIgnoreCase(banda.getNome());
    }


}