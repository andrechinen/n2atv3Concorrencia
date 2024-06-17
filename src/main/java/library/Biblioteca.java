package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro '" + livro.getTitulo() + "' foi adicionado na lista com sucesso");
    }

    public boolean alugarLivro(String nome) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(nome) && livro.getExemplares() > 0) {
                livro.setExemplaresAlugados(livro.getExemplaresAlugados() + 1);
                livro.setExemplares(livro.getExemplares() - 1);
                System.out.println("Livro '" + livro.getTitulo() + "' foi alugado com sucesso");
                return true;
            }
        }
        return false;
    }

    public boolean devolverLivro(String nome) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(nome) && livro.getExemplaresAlugados() > 0) {
                livro.setExemplaresAlugados(livro.getExemplaresAlugados() - 1);
                livro.setExemplares(livro.getExemplares() + 1);
                System.out.println("Livro '" + livro.getTitulo() + "' foi devolvido com sucesso");
                return true;
            }
        }
        return false;
    }

    public boolean removerLivro(String nome) {
        Iterator<Livro> iterator = livros.iterator();
        while (iterator.hasNext()) {
            Livro livro = iterator.next();
            if (livro.getTitulo().equalsIgnoreCase(nome)) {
                iterator.remove();
                System.out.println("Livro '" + livro.getTitulo() + "' foi removido da lista com sucesso");
                return true;
            }
        }
        return false;
    }

    // Formato que a classe vai ser printada
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Livro livro : livros) {
            sb.append(livro).append("\n");
        }
        return sb.toString();
    }
}