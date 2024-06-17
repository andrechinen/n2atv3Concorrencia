package library;

public class Livro {
    private String autor;
    private String titulo;
    private String genero;
    private int exemplares;
    private int exemplaresAlugados;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getExemplares() {
        return exemplares;
    }

    public void setExemplares(int exemplares) {
        this.exemplares = exemplares;
    }

    public int getExemplaresAlugados() {
        return exemplaresAlugados;
    }

    public void setExemplaresAlugados(int exemplaresAlugados) {
        this.exemplaresAlugados = exemplaresAlugados;
    }

    // Formato que a classe vai ser printada
    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", exemplares=" + exemplares +
                '}';
    }
}