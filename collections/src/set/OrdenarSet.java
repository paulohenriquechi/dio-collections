package set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class OrdenarSet {
    public static void main(String[] args) {
        //ordem aleatoria
        Set<Anime> meusAnimes = new HashSet<>(){{
            add(new Anime("Fate/Zero", "Açao", 25));
            add(new Anime("Hellsing", "Seinen", 60));
            add(new Anime("Hunter x Hunter", "Shonen", 20));
        }};
        for (Anime anime : meusAnimes) {
            System.out.println(anime);
        }

        //ordem de inserção
        Set<Anime> meusAnimes2 = new LinkedHashSet<>(){{
            add(new Anime("Fate/Zero", "Açao", 25));
            add(new Anime("Hellsing", "Seinen", 60));
            add(new Anime("Hunter x Hunter", "Shonen", 20));
            add(new Anime("Berserk", "Seinen", 20));

        }};
        for (Anime anime : meusAnimes2) {
            System.out.println(anime);
        }

        //ordem natural (tempo de episodio)
        Set<Anime> meusAnimes3 = new TreeSet<>(meusAnimes2);
        System.out.println(meusAnimes3);

        //Ordem nome/genero/tempo
        Set<Anime> meusAnimes4 = new TreeSet<>(new ComparatorNomeGeneroTempo());
        meusAnimes4.addAll(meusAnimes3);
        for (Anime anime : meusAnimes4) {
            System.out.println(anime);
        }
    }
    
}
class Anime implements Comparable<Anime>{
    private String titulo;
    private String genero;
    private Integer tempoEpisodio;
    
    public Anime(String titulo, String genero, Integer tempoEpisodio) {
        this.titulo = titulo;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    @Override
    public String toString() {
        return "[titulo=" + titulo + ", genero=" + genero + ", tempoEpisodio=" + tempoEpisodio + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((genero == null) ? 0 : genero.hashCode());
        result = prime * result + ((tempoEpisodio == null) ? 0 : tempoEpisodio.hashCode());
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
        Anime other = (Anime) obj;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        if (genero == null) {
            if (other.genero != null)
                return false;
        } else if (!genero.equals(other.genero))
            return false;
        if (tempoEpisodio == null) {
            if (other.tempoEpisodio != null)
                return false;
        } else if (!tempoEpisodio.equals(other.tempoEpisodio))
            return false;
        return true;
    }

    @Override
    public int compareTo(Anime anime) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), anime.tempoEpisodio);
        if(tempoEpisodio!=0){
            return tempoEpisodio;
        }
        return this.getTitulo().compareToIgnoreCase(anime.getTitulo());
    }
    
}
class ComparatorNomeGeneroTempo implements Comparator<Anime>{

    @Override
    public int compare(Anime a1, Anime a2) {
        int nome = a1.getTitulo().compareTo(a2.getTitulo());
        if(nome!=0){
            return nome;
        }
        int genero = a1.getGenero().compareTo(a2.getGenero());
        if(genero!=0){
            return genero;
        }
        return Integer.compare(a1.getTempoEpisodio(), a2.getTempoEpisodio());
    }

}