package library;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonModel {
    private static final String path = "books.json";

    public static Biblioteca lerBiblioteca() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(path);
        if (!file.exists() || file.length() == 0) {
            return new Biblioteca();
        }
        return mapper.readValue(file, Biblioteca.class);
    }

    public static void escreverBiblioteca(Biblioteca biblioteca) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(path), biblioteca);
    }
}