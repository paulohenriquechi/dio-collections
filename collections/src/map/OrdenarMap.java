package map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class OrdenarMap {
    public static void main(String[] args) {
        //ordem aleatória - hashmap
        System.out.println("\nORDEM ALEATORIA");
        Map<String, Livro> livros = new HashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
            put("Harari, Vuval Noah", new Livro("21 Lições para o Século 21", 432));
        }};
        for (Map.Entry<String, Livro> livro : livros.entrySet()) {
            System.out.println(livro.getKey()+" - "+livro.getValue().getNome());
        }

        //ordem de inserção - linkedhashmap
        System.out.println("\nORDEM DE INSERÇÃO");
        Map<String, Livro> livros1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
            put("Harari, Vuval Noah", new Livro("21 Lições para o Século 21", 432));
        }};
        for (Map.Entry<String, Livro> livro : livros1.entrySet()) {
            System.out.println(livro.getKey()+" - "+livro.getValue().getNome());
        }

        //ordem alfabetica autores - treemap (key)
        System.out.println("\nORDEM ALFABETICA AUTORES");
        Map<String, Livro> livros2 = new TreeMap<>(livros1);
        for (Map.Entry<String, Livro> livro : livros2.entrySet()) {
            System.out.println(livro.getKey()+" - "+livro.getValue().getNome());
        }

        //ordem alfabetica livros - treeset(value)
        System.out.println("\nORDEM ALFABETICA LIVROS");
        Set<Map.Entry<String, Livro>> livros3 = new TreeSet<>(new ComparatorNome());
        livros3.addAll(livros.entrySet());
        for (Map.Entry<String, Livro> livro : livros3) {
            System.out.println(livro.getKey()+" - "+livro.getValue().getNome());
        }

        
    }
    
}
class Livro{
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Livro [nome=" + nome + ", paginas=" + paginas + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((paginas == null) ? 0 : paginas.hashCode());
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
        Livro other = (Livro) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (paginas == null) {
            if (other.paginas != null)
                return false;
        } else if (!paginas.equals(other.paginas))
            return false;
        return true;
    }
    
    
    
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Entry<String, Livro> l1, Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
    
}
