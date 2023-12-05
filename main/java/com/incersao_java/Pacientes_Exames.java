package com.incersao_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Pacientes_Exames {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/incersao_dados";
        String usuario = "root";
        String senha = "";

        // Estabelece a conexão com o banco de dados MySQL
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {

            // Criação da tabela resultados_exames
            try (Statement statement = conexao.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS resultados_exames ("
                        + "id_resultado INT AUTO_INCREMENT PRIMARY KEY,"
                        + "tipo_exame VARCHAR(255),"
                        + "resultado VARCHAR(255)"
                        + ")";
                // Executa a instrução SQL para criar a tabela resultados_exames
                statement.executeUpdate(sql);
                System.out.println("Tabela resultados_exames criada com sucesso.");
            }

            // Criação da tabela pacientes
            try (Statement statement = conexao.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS pacientes ("
                        + "id_paciente INT AUTO_INCREMENT PRIMARY KEY,"
                        + "nome_paciente VARCHAR(255),"
                        + "data_nascimento DATE"
                        + ")";
                // Executa a instrução SQL para criar a tabela pacientes
                statement.executeUpdate(sql);
                System.out.println("Tabela pacientes criada com sucesso.");
            }

            String sqlResultadosExames = "INSERT INTO resultados_exames (tipo_exame, resultado) VALUES (?, ?)";
            String sqlPacientes = "INSERT INTO pacientes (nome_paciente, data_nascimento) VALUES (?, ?)";

            try (PreparedStatement preparedStatementResultadosExames = conexao.prepareStatement(sqlResultadosExames, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement preparedStatementPacientes = conexao.prepareStatement(sqlPacientes, Statement.RETURN_GENERATED_KEYS)) {

                // Inserção de dados na tabela resultados_exames
                preparedStatementResultadosExames.setString(1, "Exame de Sangue");
                preparedStatementResultadosExames.setString(2, "Normal");
                preparedStatementResultadosExames.executeUpdate();

                preparedStatementResultadosExames.setString(1, "Raio-X");
                preparedStatementResultadosExames.setString(2, "Fratura identificada");
                preparedStatementResultadosExames.executeUpdate();

                // Inserção de dados na tabela pacientes
                preparedStatementPacientes.setString(1, "Mariana");
                preparedStatementPacientes.setString(2, "1995-06-10");
                preparedStatementPacientes.executeUpdate();

                preparedStatementPacientes.setString(1, "Rafael");
                preparedStatementPacientes.setString(2, "1987-09-25");
                preparedStatementPacientes.executeUpdate();

            } catch (SQLException e) {
                // Exibe informações detalhadas sobre o erro SQL
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
