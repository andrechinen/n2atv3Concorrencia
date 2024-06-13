# Biblioteca Socket Server

## Descrição

Este projeto implementa um servidor de biblioteca utilizando sockets em Java. O servidor gerencia um cadastro de livros, permitindo funcionalidades como listagem, aluguel, devolução, cadastro e exclusão de novos livros. Os livros são armazenados em um arquivo JSON, que serve como a "base de dados" da biblioteca.

## Funcionalidades

- **Listar Livros:** Exibe todos os livros disponíveis na biblioteca.
- **Alugar Livro:** Permite alugar um livro, diminuindo o número de exemplares disponíveis.
- **Devolver Livro:** Permite devolver um livro previamente alugado, aumentando o número de exemplares disponíveis.
- **Cadastrar Livro:** Permite adicionar um novo livro à biblioteca.
- **Excluir Livro:** Permite remover um livro específico da biblioteca.

## Estrutura do Projeto

- `Cliente.java`: Implementação do cliente que se comunica com o servidor via sockets.
- `Servidor.java`: Implementação do servidor que gerencia o cadastro de livros.
- `Biblioteca.java`: Classe que representa a biblioteca e gerencia a lista de livros.
- `Livro.java`: Classe que representa um livro.
- `JsonUtils.java`: Classe utilitária para leitura e escrita do arquivo JSON.

## Requisitos

- Java 17
- Biblioteca Jackson para manipulação de JSON

## Exemplo de Uso

1. Inicie o servidor.
2. Conecte-se ao servidor através do cliente.
3. Utilize os comandos `LISTAR`, `ALUGAR`, `DEVOLVER`, `CADASTRAR`, `EXCLUIR` e `SAIR` para interagir com a biblioteca.

### Comandos Disponíveis

- **1**: Lista todos os livros disponíveis na biblioteca.
- **2**: Aluga um livro especificado pelo nome.
- **3**: Devolve um livro especificado pelo nome, apenas se foi previamente alugado.
- **4**: Cadastra um novo livro na biblioteca solicitando informações como autor, nome, gênero e número de exemplares.
- **5**: Remove um livro especificado pelo nome da biblioteca.
- **0**: Encerra a conexão com o servidor.
