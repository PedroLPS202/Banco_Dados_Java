package com.moises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TabelaProdutos {


    public static void main(String[] args) {
    
    String host = "localhost";
    String database = "exercicios2";
    String usuario = "root";
    String senha = "";
    
    try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, usuario, senha)) {
    
        String nome = "1994-11-03";
        int quantidade = "solar";
        double valor =
        String data_compra =

        String sql = "INSERT INTO estoque (nome, quantidade, valor, data_compra) VALUES(?, ?, ?, ?)";
        PreparedStatement statement = conexao.prepareStatement(sql);

        statement.setString(1,nome);
        statement.setInt(2,quantidade);
        statement.setDouble(3, valor);
        statement.setString(4,data_compra);

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



