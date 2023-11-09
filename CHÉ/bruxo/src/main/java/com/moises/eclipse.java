package com.moises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class eclipse {
    /**
     * @param args
     */
    public static void main(String[] args) {
    
    String host = "localhost";
    String database = "exercicios2";
    String usuario = "root";
    String senha = "";
    
    try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, usuario, senha)) {
    
        String data = "1994-11-03";
        String tipo = "solar";

        String sql = "INSERT INTO eclipses_solares (data, tipo) VALUES(?, ?)";
        PreparedStatement statement = conexao.prepareStatement(sql);

        statement.setString(1,data);
        statement.setString(2,tipo);

    final int linhasAfetadas = statement.executeUpdate();

        if (linhasAfetadas > 0) {
        System.out.println("eclipse adicionado com sucesso!");
        } else {
        System.out.println("Erro ao inserir eclipse.");
        }

    } catch (SQLException e) {
        System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
    }
                
    }
}

