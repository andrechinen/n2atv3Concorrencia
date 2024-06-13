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
    }

    public boolean alugarLivro(String nome) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(nome) && livro.getExemplares() > 0) {
                livro.setExemplaresAlugados(livro.getExemplaresAlugados() + 1);
                livro.setExemplares(livro.getExemplares() - 1);
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
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Livro livro : livros) {
            sb.append(livro).append("\n");
        }
        return sb.toString();
    }
}