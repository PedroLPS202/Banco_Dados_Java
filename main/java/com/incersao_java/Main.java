package com.incersao_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/incersao_dados";
        String usuario = "root";
        String senha = "";

        // Estabelece a conexão com o banco de dados MySQL
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {

            // Criação da tabela alunos
            try (Statement statement = conexao.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS alunos ("
                        + "id_aluno INT AUTO_INCREMENT PRIMARY KEY,"
                        + "nome VARCHAR(255),"
                        + "turma VARCHAR(255)"
                        + ")";
                // Executa a instrução SQL para criar a tabela alunos
                statement.executeUpdate(sql);
                System.out.println("Tabela alunos criada com sucesso.");
            }

            // Criação da tabela cursos
            try (Statement statement = conexao.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS cursos ("
                        + "id_curso INT AUTO_INCREMENT PRIMARY KEY,"
                        + "nome_curso VARCHAR(255),"
                        + "instrutor VARCHAR(255)"
                        + ")";
                // Executa a instrução SQL para criar a tabela cursos
                statement.executeUpdate(sql);
                System.out.println("Tabela cursos criada com sucesso.");
            }

            String sqlAluno = "INSERT INTO alunos (id_aluno, nome, turma) VALUES (?, ?, ?)";
            String sqlCurso = "INSERT INTO cursos (id_curso, nome_curso, instrutor) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatementAluno = conexao.prepareStatement(sqlAluno);
                 PreparedStatement preparedStatementCurso = conexao.prepareStatement(sqlCurso)) {

                // Inserção de dados na tabela alunos
                preparedStatementAluno.setInt(1, 1);
                preparedStatementAluno.setString(2, "Lucas");
                preparedStatementAluno.setString(3, "Turma A");
                preparedStatementAluno.executeUpdate();

                preparedStatementAluno.setInt(1, 2); // Usando ID diferente para o segundo aluno
                preparedStatementAluno.setString(2, "Julia");
                preparedStatementAluno.setString(3, "Turma B");
                preparedStatementAluno.executeUpdate();

                // Inserção de dados na tabela cursos
                preparedStatementCurso.setInt(1, 1);
                preparedStatementCurso.setString(2, "Matematica");
                preparedStatementCurso.setString(3, "Carlos");
                preparedStatementCurso.executeUpdate();

                preparedStatementCurso.setInt(1, 2); // Usando ID diferente para o segundo curso
                preparedStatementCurso.setString(2, "Ciencias");
                preparedStatementCurso.setString(3, "Ana");
                preparedStatementCurso.executeUpdate();

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
    