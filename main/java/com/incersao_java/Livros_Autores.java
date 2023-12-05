package com.incersao_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Livros_Autores {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/incersao_dados";
        String usuario = "root";
        String senha = "";

        // Estabelece a conexão com o banco de dados MySQL
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {

                // Criação da tabela alunos
            try (Statement statement = conexao.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS livros ("
                        + "id_livro INT AUTO_INCREMENT PRIMARY KEY,"
                        + "título VARCHAR(255),"
                        + "ano_publicação DATE"
                        + ")";
                // Executa a instrução SQL para criar a tabela livros
                statement.executeUpdate(sql);
                System.out.println("Tabela livros criada com sucesso.");
            }

            // Criação da tabela cursos
            try (Statement statement = conexao.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS autores ("
                        + "id_autor INT AUTO_INCREMENT PRIMARY KEY,"
                        + "nome_autor VARCHAR(255)"
                        + ")";
                // Executa a instrução SQL para criar a tabela autores
                statement.executeUpdate(sql);
                System.out.println("Tabela autores criada com sucesso.");
            }

        String sqlLivros = "INSERT INTO livros (id_livro, título, ano_publicação) VALUES (?, ?, ?)";
        String sqlAutores = "INSERT INTO autores (id_autor, nome_autor) VALUES (?, ?)";

            try (PreparedStatement preparedStatementLivro = conexao.prepareStatement(sqlLivros);
                 PreparedStatement preparedStatementAutores = conexao.prepareStatement(sqlAutores)) {

                // Inserção de dados na tabela alunos
                preparedStatementLivro.setInt(1, 1);
                preparedStatementLivro.setString(2, "Aprendendo Python");
                preparedStatementLivro.setString(3, "2020");
                preparedStatementLivro.executeUpdate();

                preparedStatementLivro.setInt(1, 2); // Usando ID diferente para o segundo aluno
                preparedStatementLivro.setString(2, "Introdução à Inteligência Artificial");
                preparedStatementLivro.setString(3, "2019");
                preparedStatementLivro.executeUpdate();

                // Inserção de dados na tabela cursos
                preparedStatementAutores.setInt(1, 1);
                preparedStatementAutores.setString(2, "Carlos Silva");
                preparedStatementAutores.executeUpdate();

                preparedStatementAutores.setInt(1, 2); // Usando ID diferente para o segundo curso
                preparedStatementAutores.setString(2, "Ana Souza");
                preparedStatementAutores.executeUpdate();

            } catch (SQLException e) {
                // Exibe informações detalhadas sobre o erro SQL
                e.printStackTrace();
            } catch (Exception e) {
                // Exibe outras exceções
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // Exibe informações detalhadas sobre o erro SQL
            e.printStackTrace();
        } catch (Exception e) {
            // Exibe outras exceções
            e.printStackTrace();
        }
    }
}
