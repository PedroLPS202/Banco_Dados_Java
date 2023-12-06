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
            try {
                // Exclusão do paciente com todos os exames associados
                excluirPacienteExames(conexao, 1); // Substitua 1 pelo ID do paciente que deseja excluir

                // Se não houve exceções, commita a transação
                conexao.commit();
            } catch (SQLException e) {
                // Em caso de exceção, faz rollback para desfazer alterações
                conexao.rollback();
                e.printStackTrace();
            }

            // Criação da tabela resultados_exames
            try (Statement statement = conexao.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS resultados_exames ("
                        + "id_resultado INT AUTO_INCREMENT PRIMARY KEY,"
                        + "tipo_exame VARCHAR(255),"
                        + "resultado VARCHAR(255),"
                        + "id_paciente INT,"
                        + "FOREIGN KEY (id_paciente) REFERENCES pacientes(id_paciente)"
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

            String sqlResultadosExames = "INSERT INTO resultados_exames (tipo_exame, resultado, id_paciente) VALUES (?, ?, ?)";
            String sqlPacientes = "INSERT INTO pacientes (nome_paciente, data_nascimento) VALUES (?, ?)";

            try (PreparedStatement preparedStatementResultadosExames = conexao.prepareStatement(sqlResultadosExames, Statement.RETURN_GENERATED_KEYS);
                    PreparedStatement preparedStatementPacientes = conexao.prepareStatement(sqlPacientes, Statement.RETURN_GENERATED_KEYS)) {

                // Inserção de dados na tabela resultados_exames
                preparedStatementResultadosExames.setString(1, "Exame de Sangue");
                preparedStatementResultadosExames.setString(2, "Normal");
                preparedStatementResultadosExames.setInt(3, 1); // Substitua 1 pelo ID do paciente associado ao exame
                preparedStatementResultadosExames.executeUpdate();

                preparedStatementResultadosExames.setString(1, "Raio-X");
                preparedStatementResultadosExames.setString(2, "Fratura identificada");
                preparedStatementResultadosExames.setInt(3, 2); // Substitua 2 pelo ID do paciente associado ao exame
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

    private static void excluirPacienteExames(Connection conexao, int idPaciente) {
        try {
            // Exclua o paciente
            String sqlExcluirPaciente = "DELETE FROM pacientes WHERE id_paciente = ?";
            try (PreparedStatement preparedStatementExcluirPaciente = conexao.prepareStatement(sqlExcluirPaciente)) {
                preparedStatementExcluirPaciente.setInt(1, idPaciente);
                preparedStatementExcluirPaciente.executeUpdate();
            }

            // Exclua os exames associados ao paciente
            String sqlExcluirExamesDoPaciente = "DELETE FROM resultados_exames WHERE id_paciente = ?";
            try (PreparedStatement preparedStatementExcluirExames = conexao.prepareStatement(sqlExcluirExamesDoPaciente)) {
                preparedStatementExcluirExames.setInt(1, idPaciente);
                preparedStatementExcluirExames.executeUpdate();
            }

        } catch (SQLException e) {
            // Exibe informações detalhadas sobre o erro SQL
            e.printStackTrace();
        }
    }
}
