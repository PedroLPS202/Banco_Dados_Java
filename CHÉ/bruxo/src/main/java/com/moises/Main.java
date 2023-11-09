package com.moises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
    String host = "localhost";
    String database = "exercicios2";
    String usuario = "root";
    String senha = "";
    
    try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, usuario, senha)) {
    
        String moeda = "Dolar";
        Double valor = 5.00;

        String sql = "INSERT INTO cotacao_moeda (moeda, valor) VALUES(?, ?)";
        PreparedStatement statement = conexao.prepareStatement(sql);

        statement.setString(1,moeda);
        statement.setDouble(2, valor);

    int linhasAfetadas = statement.executeUpdate();

        if (linhasAfetadas > 0) {
        System.out.println("Produto adicionado com sucesso!");
        } else {
        System.out.println("Erro ao inserir moeda.");
        }

    } catch (SQLException e) {
        System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
    }
                
    }
}