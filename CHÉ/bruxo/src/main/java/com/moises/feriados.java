package com.moises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class feriados {
    public static void main(String[] args) {
    
    String host = "localhost";
    String database = "exercicios2";
    String usuario = "root";
    String senha = "";
    
    try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, usuario, senha)) {
    
        String data = "2023-09-07";
        String descricao = "Comemoramos a indepêndencia da nossa nação a coroa de Portugal ";

        String sql = "INSERT INTO feriados_nacionais (data, descricao) VALUES(?, ?)";
        PreparedStatement statement = conexao.prepareStatement(sql);

        statement.setString(1,data);
        statement.setString(2,descricao);

    int linhasAfetadas = statement.executeUpdate();

        if (linhasAfetadas > 0) {
        System.out.println("Feriado adicionado com sucesso!");
        } else {
        System.out.println("Erro ao inserir Feriado.");
        }

    } catch (SQLException e) {
        System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
    }
                
    }
}

