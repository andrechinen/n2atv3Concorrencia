package library;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("SERVIDOR INICIADO");
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("CONECTOU");
                    atenderCliente(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void atenderCliente(Socket socket) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            Biblioteca biblioteca = JsonModel.lerBiblioteca();
            String comando;

            while ((comando = in.readLine()) != null) {
                switch (comando) {
                    case "1":
                        out.println(biblioteca);
                        out.println("END"); 
                        break;
                    case "2":
                        String livroParaAlugar = in.readLine();
                        if (biblioteca.alugarLivro(livroParaAlugar)) {
                            JsonModel.escreverBiblioteca(biblioteca);
                            out.println("Livro alugado com sucesso");
                        } else {
                            out.println("Livro não disponível");
                        }
                        break;
                    case "3":
                        String livroParaDevolver = in.readLine();
                        if (biblioteca.devolverLivro(livroParaDevolver)) {
                            JsonModel.escreverBiblioteca(biblioteca);
                            out.println("Livro devolvido com sucesso");
                        } else {
                            out.println("Erro ao devolver livro");
                        }
                        break;
                    case "4":
                        String novoLivroJson = in.readLine();
                        Livro novoLivro = new ObjectMapper().readValue(novoLivroJson, Livro.class);
                        biblioteca.adicionarLivro(novoLivro);
                        JsonModel.escreverBiblioteca(biblioteca);
                        out.println("Livro cadastrado com sucesso");
                        break;
                    case "5":
                        String livroParaExcluir = in.readLine();
                        if (biblioteca.removerLivro(livroParaExcluir)) {
                            JsonModel.escreverBiblioteca(biblioteca);
                            out.println("Livro excluído com sucesso");
                        } else {
                            out.println("Livro não encontrado");
                        }
                        break;
                    default:
                        out.println("Comando desconhecido");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}