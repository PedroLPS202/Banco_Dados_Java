package com.incersao_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Eventos_Participantes {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/incersao_dados";
        String usuario = "root";
        String senha = "";

        // Estabelece a conexão com o banco de dados MySQL
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {

                // Criação da tabela alunos
            try (Statement statement = conexao.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS eventos ("
                        + "id_evento INT AUTO_INCREMENT PRIMARY KEY,"
                        + "nome_evento VARCHAR(255),"
                        + "data VARCHAR(255)"
                        + ")";
                // Executa a instrução SQL para criar a tabela eventos
                statement.executeUpdate(sql);
                System.out.println("Tabela eventos criada com sucesso.");
            }

            // Criação da tabela cursos
            try (Statement statement = conexao.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS participantes ("
                        + "id_participantes INT AUTO_INCREMENT PRIMARY KEY,"
                        + "id_evento INT(2),"
                        + "nome_participantes VARCHAR(255)"
                        + ")";
                // Executa a instrução SQL para criar a tabela participantes
                statement.executeUpdate(sql);
                System.out.println("Tabela participantes criada com sucesso.");
            }

            String sqlEventos = "INSERT INTO eventos (id_evento, nome_evento, data) VALUES (?, ?, ?)";
            String sqlParticipantes = "INSERT INTO participantes (id_participantes, id_evento, nome_participantes) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatementEventos = conexao.prepareStatement(sqlEventos);
                 PreparedStatement preparedStatementParticipantes = conexao.prepareStatement(sqlParticipantes)) {

                // Inserção de dados na tabela alunos
                preparedStatementEventos.setInt(1, 1);
                preparedStatementEventos.setString(2, "Conferência de Tecnologia");
                preparedStatementEventos.setString(3, "2023-12-15");
                preparedStatementEventos.executeUpdate();

                preparedStatementEventos.setInt(1, 2); // Usando ID diferente para o segundo 
                preparedStatementEventos.setString(2, "Workshop de Marketing Digital");
                preparedStatementEventos.setString(3, "2023-11-20");
                preparedStatementEventos.executeUpdate();

                // Inserção de dados na tabela cursos
                preparedStatementParticipantes.setInt(1, 1);
                preparedStatementParticipantes.setInt(2, 1);
                preparedStatementParticipantes.setString(3, "Gabriel");
                preparedStatementParticipantes.executeUpdate();

                preparedStatementParticipantes.setInt(1, 2); // Usando ID diferente para o segundo participantes
                preparedStatementParticipantes.setInt(2, 2);
                preparedStatementParticipantes.setString(3, "Sofia");
                preparedStatementParticipantes.executeUpdate();

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
    


