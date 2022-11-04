package set.ex02;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*
Crie uma classe LinguagemFavorita que possua os atributos
nome, anoDeCriacao e ide. Em seguida, crie um conjunto com
3 linguagens e faça um programa que ordene esse conjunto
por:

Ordem de Inserção ok

Ordem Natural (nome) ok

IDE 

Ano de criação e nome

Nome, ano de criacao e IDE

Ao final, exiba as linguagens no console, um abaixo da outra.
 */
public class Ex02 {
    public static void main(String[] args) {
        Set<LinguagemFavorita> linguagens = new LinkedHashSet<>(){{
            add(new LinguagemFavorita("Java", 1995, "IntelliJ"));
            add(new LinguagemFavorita("Python", 1991, "Pycharm"));
            add(new LinguagemFavorita("JavaScript", 1995, "VSCode"));
        }};
        System.out.println("\nLinguagens de Programaçao por ordem de inserçao: ");
        for (LinguagemFavorita linguagem : linguagens) {
            System.out.println(linguagem);
        }

        System.out.println("\nLinguagens de Programaçao por ordem alfabetica: ");
        Set<LinguagemFavorita> linguagensAlfa = new TreeSet<>(new ComparatorNome());
        linguagensAlfa.addAll(linguagens);
        for (LinguagemFavorita linguagem : linguagensAlfa) {
            System.out.println(linguagem);
        }
    }
}
class LinguagemFavorita{
    private String nome;
    private int anoDeCriacao;
    private String ide;
    public LinguagemFavorita(String nome, int anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getAnoDeCriacao() {
        return anoDeCriacao;
    }
    public void setAnoDeCriacao(int anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }
    public String getIde() {
        return ide;
    }
    public void setIde(String ide) {
        this.ide = ide;
    }
    @Override
    public String toString() {
        return "Linguagem: " + nome + ", Ano de Criacao: " + anoDeCriacao + ", IDE: " + ide + "";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + anoDeCriacao;
        result = prime * result + ((ide == null) ? 0 : ide.hashCode());
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
        LinguagemFavorita other = (LinguagemFavorita) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (anoDeCriacao != other.anoDeCriacao)
            return false;
        if (ide == null) {
            if (other.ide != null)
                return false;
        } else if (!ide.equals(other.ide))
            return false;
        return true;
    }

}
class ComparatorNome implements Comparator<LinguagemFavorita>{
    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        return o1.getNome().compareToIgnoreCase(o2.getNome());
    }


}
