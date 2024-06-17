package library;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // É usado para enviar dados do cliente para o servidor
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Serve para receber dados do servidor para o cliente
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("\nDigite um número: \n1 - LISTAR \n2 - ALUGAR \n3 - DEVOLVER \n4 - CADASTRAR \n5 - EXCLUIR \n0 - SAIR");
                String comando = scanner.nextLine().toUpperCase();

                if (comando.equals("0")) {
                    break;
                }

                out.println(comando);

                switch (comando) {
                    case "1":
                        System.out.println("Livros disponíveis:");
                        String response;
                        while (!(response = in.readLine()).equals("END")) {
                            System.out.println(response);
                        }
                        break;
                    case "2":
                        System.out.println("Digite o nome do livro para alugar:");
                        String livroParaAlugar = scanner.nextLine();
                        out.println(livroParaAlugar);
                        System.out.println(in.readLine());
                        break;
                    case "3":
                        System.out.println("Digite o nome do livro para devolver:");
                        String livroParaDevolver = scanner.nextLine();
                        out.println(livroParaDevolver);
                        System.out.println(in.readLine());
                        break;
                    case "4":
                        System.out.println("Digite o titulo do livro:");
                        String titulo = scanner.nextLine();
                        System.out.println("Digite o autor do livro:");
                        String autor = scanner.nextLine();
                        System.out.println("Digite o gênero do livro:");
                        String genero = scanner.nextLine();
                        System.out.println("Digite o número de exemplares:");
                        int exemplares = scanner.nextInt();
                        scanner.nextLine(); 

                        Livro novoLivro = new Livro();
                        novoLivro.setTitulo(titulo);
                        novoLivro.setAutor(autor);
                        novoLivro.setGenero(genero);
                        novoLivro.setExemplares(exemplares);

                        ObjectMapper objectMapper = new ObjectMapper();
                        String novoLivroJson = objectMapper.writeValueAsString(novoLivro);
                        out.println(novoLivroJson);
                        System.out.println(in.readLine());
                        break;
                    case "5":
                        System.out.println("Digite o nome do livro para excluir:");
                        String livroParaExcluir = scanner.nextLine();
                        out.println(livroParaExcluir);
                        System.out.println(in.readLine());
                        break;
                    default:
                        System.out.println("Comando desconhecido");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}