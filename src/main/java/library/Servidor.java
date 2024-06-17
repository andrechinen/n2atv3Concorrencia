package library;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor Iniciado");
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Usuario conectou");
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
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Serve para receber dados do cliente para o servidor
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)// É usado para enviar dados do servidor para o cliente
        ) {
            Biblioteca biblioteca = JsonModel.lerBiblioteca();
            String comando;

            while ((comando = in.readLine()) != null) {
                switch (comando) {
                    case "1":
                        out.println(biblioteca);
                        out.println("END"); 
                        System.out.println("Lista de livros foi mostrado");
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