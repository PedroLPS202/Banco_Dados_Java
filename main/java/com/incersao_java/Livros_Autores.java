/*package com.incersao_java;

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

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            try {
                // Exclusão do aluno com todas as associações
                excluirAlunoCursos(conexao, 1); // Substitua 1 pelo ID do aluno que deseja excluir

                // Se não houve exceções, commita a transação
                conexao.commit();
            } catch (SQLException e) {
                // Em caso de exceção, faz rollback para desfazer alterações
                conexao.rollback();
                e.printStackTrace();
            }

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

            String sqlAluno = "INSERT INTO alunos (nome, turma) VALUES (?, ?)";
            String sqlCurso = "INSERT INTO cursos (nome_curso, instrutor) VALUES (?, ?)";

            try (PreparedStatement preparedStatementAluno = conexao.prepareStatement(sqlAluno, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement preparedStatementCurso = conexao.prepareStatement(sqlCurso, Statement.RETURN_GENERATED_KEYS)) {

                // Inserção de dados na tabela alunos
                preparedStatementAluno.setString(1, "Lucas");
                preparedStatementAluno.setString(2, "Turma A");
                preparedStatementAluno.executeUpdate();

                preparedStatementAluno.setString(1, "Julia");
                preparedStatementAluno.setString(2, "Turma B");
                preparedStatementAluno.executeUpdate();

                // Inserção de dados na tabela cursos
                preparedStatementCurso.setString(1, "Matematica");
                preparedStatementCurso.setString(2, "Carlos");
                preparedStatementCurso.executeUpdate();

                preparedStatementCurso.setString(1, "Ciencias");
                preparedStatementCurso.setString(2, "Ana");
                preparedStatementCurso.executeUpdate();

            } catch (SQLException e) {
                // Exibe informações detalhadas sobre o erro SQL
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // Exibe informações detalhadas sobre o erro SQL
            e.printStackTrace();
        }

        private static void excluirAlunoCursos(Connection conexao, int idAluno) {
            try {
                // Exclua o aluno
                String sqlExcluirAluno = "DELETE FROM alunos WHERE id_aluno = ?";
                try (PreparedStatement preparedStatementExcluirAluno = conexao.prepareStatement(sqlExcluirAluno)) {
                    preparedStatementExcluirAluno.setInt(1, idAluno);
                    preparedStatementExcluirAluno.executeUpdate();
                }
    
                // Exclua os cursos associados ao aluno
                String sqlExcluirCursosDoAluno = "DELETE FROM cursos WHERE id_aluno = ?";
                try (PreparedStatement preparedStatementExcluirCursos = conexao.prepareStatement(sqlExcluirCursosDoAluno)) {
                    preparedStatementExcluirCursos.setInt(1, idAluno);
                    preparedStatementExcluirCursos.executeUpdate();
                }
    
            } catch (SQLException e) {
                // Exibe informações detalhadas sobre o erro SQL
                e.printStackTrace();
            }
        }
    }
}*/

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

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            try {
                // Exclusão do aluno com todas as associações
                excluirAlunoCursos(conexao, 1); // Substitua 1 pelo ID do aluno que deseja excluir

                // Se não houve exceções, commita a transação
                conexao.commit();
            } catch (SQLException e) {
                // Em caso de exceção, faz rollback para desfazer alterações
                conexao.rollback();
                e.printStackTrace();
            }

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

            String sqlAluno = "INSERT INTO alunos (nome, turma) VALUES (?, ?)";
            String sqlCurso = "INSERT INTO cursos (nome_curso, instrutor) VALUES (?, ?)";

            try (PreparedStatement preparedStatementAluno = conexao.prepareStatement(sqlAluno, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement preparedStatementCurso = conexao.prepareStatement(sqlCurso, Statement.RETURN_GENERATED_KEYS)) {

                // Inserção de dados na tabela alunos
                preparedStatementAluno.setString(1, "Lucas");
                preparedStatementAluno.setString(2, "Turma A");
                preparedStatementAluno.executeUpdate();

                preparedStatementAluno.setString(1, "Julia");
                preparedStatementAluno.setString(2, "Turma B");
                preparedStatementAluno.executeUpdate();

                // Inserção de dados na tabela cursos
                preparedStatementCurso.setString(1, "Matematica");
                preparedStatementCurso.setString(2, "Carlos");
                preparedStatementCurso.executeUpdate();

                preparedStatementCurso.setString(1, "Ciencias");
                preparedStatementCurso.setString(2, "Ana");
                preparedStatementCurso.executeUpdate();

            } catch (SQLException e) {
                // Exibe informações detalhadas sobre o erro SQL
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // Exibe informações detalhadas sobre o erro SQL
            e.printStackTrace();
        }
    }

    private static void excluirAlunoCursos(Connection conexao, int idAluno) {
        try {
            // Exclua o aluno
            String sqlExcluirAluno = "DELETE FROM alunos WHERE id_aluno = ?";
            try (PreparedStatement preparedStatementExcluirAluno = conexao.prepareStatement(sqlExcluirAluno)) {
                preparedStatementExcluirAluno.setInt(1, idAluno);
                preparedStatementExcluirAluno.executeUpdate();
            }

            // Exclua os cursos associados ao aluno
            String sqlExcluirCursosDoAluno = "DELETE FROM cursos WHERE id_aluno = ?";
            try (PreparedStatement preparedStatementExcluirCursos = conexao.prepareStatement(sqlExcluirCursosDoAluno)) {
                preparedStatementExcluirCursos.setInt(1, idAluno);
                preparedStatementExcluirCursos.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


    
